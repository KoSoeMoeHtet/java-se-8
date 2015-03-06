package com.solt.balance.view;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.solt.balance.model.BalanceModel;
import com.solt.balance.model.CategoryModel;
import com.solt.balance.model.EmployeeModel;
import com.solt.balance.model.entity.Balance;
import com.solt.balance.model.entity.Category;
import com.solt.balance.model.entity.Employee;
import com.solt.balance.view.cell.CategoryCallback;
import com.solt.balance.view.cell.DateCallBack;
import com.solt.balance.view.cell.EmployeeCallback;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Expenses implements Initializable{

	@FXML
	private ComboBox<Employee> employees;
	@FXML
	private ComboBox<Category> categories;
	@FXML
	private TextField amount;
	@FXML
	private TextArea remark;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			employees.getItems().addAll(EmployeeModel.getModel().getAll());
			categories.getItems().addAll(
					CategoryModel.getModel().getWhere(
							a -> a.getType().equals("OUT")));
			
			colEmployee.setCellFactory(new EmployeeCallback());
			colCategory.setCellFactory(new CategoryCallback());
			colDate.setCellFactory(new DateCallBack());
			colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

		} catch (IOException e) {
			System.err.println("No File");
		}
	}

	public void clear() {
		amount.clear();
		employees.getSelectionModel().clearSelection();
		categories.getSelectionModel().clearSelection();
		table.getItems().clear();
	}

	public void add() {
		try {
			// get checked balance
			Balance b = this.getCheckedBalance();
			// add to table
			this.table.getItems().add(b);
		} catch (RuntimeException e) {
			e.printStackTrace();
			MessageView.showMessage("Warning", e.getMessage(), table.getScene()
					.getWindow());
		}
	}

	private Balance getCheckedBalance() {
		Employee e = employees.getSelectionModel().getSelectedItem();

		if (null == e)
			throw new RuntimeException("Please select a staff!");

		Category c = categories.getSelectionModel().getSelectedItem();

		if (null == c)
			throw new RuntimeException("Please select category!");

		int a = 0;

		try {
			a = Integer.parseInt(amount.getText());
		} catch (Exception ex) {
			if (ex instanceof NumberFormatException) {
				throw new RuntimeException("Please set amount in Integer!");
			}
		}

		Balance b = new Balance();
		b.setAmount(a);
		b.setCategory(c);
		b.setEmployee(e);
		b.setDate(new Date());
		b.setRemark(remark.getText());

		return b;
	}

	public void save() {
		table.getItems().forEach(a -> {
			try {
					BalanceModel.getModel().add(a);
				} catch(Exception e) {
					System.err.println(e.getMessage());
				}
			});
		
		this.clear();
	}
}
