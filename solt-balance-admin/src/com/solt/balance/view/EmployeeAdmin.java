package com.solt.balance.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.solt.balance.model.EmployeeModel;
import com.solt.balance.model.entity.Employee;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeAdmin implements Initializable{
	
	@FXML
	private TextField name;
	@FXML
	private PasswordField pass;
	@FXML
	private ComboBox<String> roles;
	
	@FXML
	private TableView<Employee> table;
	@FXML
	private TableColumn<String, Employee> colId;
	@FXML
	private TableColumn<String, Employee> colName;
	@FXML
	private TableColumn<String, Employee> colRole;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		roles.getItems().clear();
		roles.getItems().addAll("Admin", "Developer", "Office Admin", "Marketing");
		
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colRole.setCellValueFactory(new PropertyValueFactory<>("role"));

		// reload
		this.reload();
	}
	
	public void clear() {
		name.clear();
		pass.clear();
		roles.getSelectionModel().clearSelection();
	}
	
	public void save() {
		
		try {
			// get checked data
			Employee e = this.getCheckedData();
			
			// add to model
			EmployeeModel.getModel().add(e);
			
			// reload table
			this.reload();
			
		} catch(RuntimeException e) {
			MessageView.showMessage("Warning", e.getMessage(), table.getScene().getWindow());
			e.printStackTrace();
		} catch (IOException e1) {
			System.err.println(e1.getMessage());
		}
		
	}
	
	private Employee getCheckedData() {
		String strName = name.getText();
		if(strName == null || strName.isEmpty()) {
			throw new RuntimeException("You need to enter name.");
		}
		
		String strPass = pass.getText();
		if(strPass == null 
				|| strPass.isEmpty() 
				|| strPass.length() != 6
				) {
			throw new RuntimeException("You should add password on 6 char.");
		}
		
		String strRole = roles.getSelectionModel().getSelectedItem();
		if(strRole == null || strRole.isEmpty()) {
			throw new RuntimeException("You should select a role.");
		}
		
		Employee e = new Employee();
		e.setName(strName);
		e.setPassword(strPass);
		e.setRole(strRole);
		
		return e;
	}

	private void reload() {
		table.getItems().clear();
		table.getItems().addAll(EmployeeModel.getModel().getAll());
		clear();
	}

}
