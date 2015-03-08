package com.solt.balance.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.solt.balance.model.BalanceModel;
import com.solt.balance.model.CategoryModel;
import com.solt.balance.model.EmployeeModel;
import com.solt.balance.model.entity.Balance;
import com.solt.balance.model.entity.Category;
import com.solt.balance.model.entity.Employee;
import com.solt.balance.view.MessageView;
import com.solt.balance.view.cell.AmountCellFactory;
import com.solt.balance.view.cell.CategoryCallback;
import com.solt.balance.view.cell.DateCallBack;
import com.solt.balance.view.cell.EmployeeCallback;

public class Balances implements Initializable {

	@FXML
	private DatePicker from;
	@FXML
	private DatePicker to;
	@FXML
	private ComboBox<Category> categories;
	@FXML
	private ComboBox<Employee> employees;

	@FXML
	private TableView<Balance> table;
	@FXML
	private TableColumn<Balance, String> colDate;
	@FXML
	private TableColumn<Balance, String> colCategory;
	@FXML
	private TableColumn<Balance, String> colEmp;
	@FXML
	private TableColumn<Balance, String> colIncome;
	@FXML
	private TableColumn<Balance, String> colExpense;
	@FXML
	private TableColumn<Balance, String> colBalance;

	private Predicate<Balance> where = a -> {
		LocalDateTime businessDate = LocalDateTime.ofInstant(a.getDate()
				.toInstant(), ZoneId.systemDefault());

		// check date
		if (from.getValue().atStartOfDay().isBefore(businessDate)
				&& to.getValue().plusDays(1).atStartOfDay()
						.isAfter(businessDate)) {
			// check category
			if (!categories.getSelectionModel().isEmpty()
					&& categories.getSelectionModel().getSelectedItem().getId() != a
							.getCategory().getId()) {
				return false;
			}

			if (!employees.getSelectionModel().isEmpty()
					&& employees.getSelectionModel().getSelectedItem().getId() != a
							.getEmployee().getId()) {
				return false;
			}

			return true;
		}

		return false;
	};

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			// define cell factory
			colDate.setCellFactory(new DateCallBack());
			colCategory.setCellFactory(new CategoryCallback());
			colEmp.setCellFactory(new EmployeeCallback());
			colIncome.setCellFactory(new AmountCellFactory(true));
			colExpense.setCellFactory(new AmountCellFactory(false));
			colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));

			this.initData();
			
			from.setOnAction(this::search);
			to.setOnAction(this::search);
			employees.setOnAction(this::search);
			categories.setOnAction(this::search);
			
		} catch (IOException e) {
			// error control
		} catch (RuntimeException e) {

		}
	}


	private void search(ActionEvent ae) {
		try {
			this.loadTable();
		} catch (RuntimeException e) {
			MessageView.showMessage("Warning", e.getMessage(), table.getScene().getWindow());
		}
	}


	private void initData() throws IOException {

		from.setValue(LocalDate.now().withDayOfMonth(1));
		to.setValue(LocalDate.now());

		categories.getItems().clear();
		categories.getItems().addAll(CategoryModel.getModel().getAll());

		employees.getItems().clear();
		employees.getItems().addAll(EmployeeModel.getModel().getAll());

		this.loadTable();

	}

	private void loadTable() {

		if (from.getValue() == null || to.getValue() == null) {
			throw new RuntimeException("Please set date values");
		}

		this.table.getItems().clear();
		this.table.getItems().addAll(BalanceModel.getModel().getWhere(where));
	}
	
	public void clear() {
		try {
			this.initData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
