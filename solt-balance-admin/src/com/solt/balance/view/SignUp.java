package com.solt.balance.view;

import java.io.IOException;

import com.solt.balance.model.EmployeeModel;
import com.solt.balance.model.entity.Employee;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp implements LoginController{
	
	@FXML
	private TextField name;
	@FXML
	private PasswordField pass1;
	@FXML
	private PasswordField pass2;
	
	private UserHomeHandler handler;
	
	public void close() {
		name.getScene().getWindow().hide();
	}
	
	public void setHandler(UserHomeHandler uh) {
		handler = uh;
	}
	
	public void signup() {
		
		try {
			Employee emp = this.getCheckedEmployee();
			EmployeeModel.getModel().add(emp);
			
			handler.openHome();
			
			this.close();
			
		} catch (IOException e) {
			System.err.println("First Time");
		} catch (RuntimeException e) {
			MessageView.showMessage("Error", e.getMessage(), name.getScene().getWindow());
		}
	}

	private Employee getCheckedEmployee() {
		Employee e = new Employee();
		
		if(name.getText().isEmpty()) {
			throw new RuntimeException("You need to enter name.");
		}
		
		if(pass1.getText().isEmpty()) {
			throw new RuntimeException("You need to enter password.");
		}
		
		if(pass2.getText().isEmpty()) {
			throw new RuntimeException("You need to enter password confirmation.");
		}
		
		if(!pass1.getText().equals(pass2.getText()))
			throw new RuntimeException("You need to enter the same passwords.");
		
		e.setName(name.getText());
		e.setPassword(pass1.getText());
		e.setRole("Admin");
	
		return e;
	}

}
