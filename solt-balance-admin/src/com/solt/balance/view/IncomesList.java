package com.solt.balance.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.solt.balance.model.BalanceModel;
import com.solt.balance.model.entity.Balance;
import com.solt.balance.view.cell.CategoryCallback;
import com.solt.balance.view.cell.DateCallBack;
import com.solt.balance.view.cell.EmployeeCallback;

public class IncomesList implements Initializable{
	
	@FXML
	private DatePicker from;
	@FXML
	private DatePicker to;
	
	@FXML
	private Label total;
	@FXML
	private TableView<Balance> table;
	@FXML
	private TableColumn<Balance, String> colDate;
	@FXML
	private TableColumn<Balance, String> colEmployee;
	@FXML
	private TableColumn<Balance, String> colCategory;
	@FXML
	private TableColumn<Balance, String> colAmount;
	@FXML
	private TableColumn<Balance, String> colRemark;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		colDate.setCellFactory(new DateCallBack());
		colEmployee.setCellFactory(new EmployeeCallback());
		colCategory.setCellFactory(new CategoryCallback());
		colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		colRemark.setCellValueFactory(new PropertyValueFactory<>("remark"));
		
		from.setValue(LocalDate.now().withDayOfMonth(1));
		to.setValue(LocalDate.now());
		
		from.setOnAction(a -> reload());
		to.setOnAction(a -> reload());
		
		this.reload();
	}

	private void reload() {
		
		// check from and to value
		if(to.getValue().isBefore(from.getValue())) {
			from.setValue(LocalDate.now().withDayOfMonth(1));
			to.setValue(LocalDate.now());
			
			MessageView.showMessage("Error", "Please set 'Date From' after 'Date To'!", table.getScene().getWindow());
		}
		
		// set table data
		table.getItems().clear();
		table.getItems().addAll(BalanceModel.getModel().getWhere(a -> {
			LocalDateTime businessDate = LocalDateTime.ofInstant(a.getDate().toInstant(), ZoneId.systemDefault());
			return a.getCategory().getType().equals("IN") &&
					businessDate.isAfter(from.getValue().atStartOfDay()) && 
					businessDate.isBefore(to.getValue().plusDays(1).atStartOfDay());
		}));
		
		// set total amount
		int totalAmount = table.getItems().stream().mapToInt(a -> a.getAmount()).sum();
		total.setText(String.valueOf(totalAmount));
	}

}
