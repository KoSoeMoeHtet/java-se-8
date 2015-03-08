package com.solt.balance.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

import com.solt.balance.model.BalanceModel;
import com.solt.balance.model.BalanceModel.CategoryType;
import com.solt.balance.model.EmployeeModel;
import com.solt.balance.model.entity.Balance;
import com.solt.balance.model.entity.Employee;

public class Home implements Initializable{
	
	@FXML
	private DatePicker from;
	@FXML
	private DatePicker to;
	@FXML
	private ComboBox<Employee> employees;
	@FXML
	private RadioButton all;
	@FXML
	private RadioButton expense;
	@FXML
	private RadioButton incomes;
	
	@FXML
	private BarChart<String, Integer> chart;
	
	private Predicate<Balance> where;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		employees.getItems().clear();
		employees.getItems().addAll(EmployeeModel.getModel().getAll());
		
		chart.getXAxis().setLabel("Category");
		chart.getYAxis().setLabel("Amount");
		
		this.clear();

		from.setOnAction(this::load);
		to.setOnAction(this::load);
		employees.setOnAction(this::load);
		all.setOnAction(this::load);
		incomes.setOnAction(this::load);
		expense.setOnAction(this::load);
		
	}
	
	public void clear() {
		try {
			from.setValue(LocalDate.now().withDayOfMonth(1));
			to.setValue(LocalDate.now());
			employees.getSelectionModel().clearSelection();
			all.setSelected(true);
			
			this.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void load(ActionEvent ae) {
		try {
			this.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void loadData() throws IOException {
		
		if(from.getValue() == null || to.getValue() == null) {
			throw new RuntimeException("Please enter date from and to values.");
		}
		
		where = a -> {
			
			LocalDateTime bDate = LocalDateTime.ofInstant(a.getDate().toInstant(), ZoneId.systemDefault());
			
			if(from.getValue().atStartOfDay().isAfter(bDate) 
					|| to.getValue().plusDays(1).atStartOfDay().isBefore(bDate)) {
				return false;
			}
			
			if(!employees.getSelectionModel().isEmpty() 
					&& a.getEmployee().getId() != employees.getSelectionModel().getSelectedItem().getId()) {
				return false;
			}
			
			return true;
		};
		
		BalanceModel.CategoryType type = CategoryType.ALL;
		
		if(expense.isSelected())
			type = CategoryType.OUT;
		
		if(incomes.isSelected())
			type = CategoryType.IN;
		
		Map<String, Integer> data = BalanceModel.getModel().getChartData(where, type);
		
		chart.getData().clear();
		
		data.entrySet().stream()
			.map(a -> new XYChart.Data<>(a.getKey(), a.getValue()))
			.forEach(a -> {
				XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
				series.setName(a.getXValue());
				series.getData().add(a);
				chart.getData().add(series);
			});
		
	}
	
}
