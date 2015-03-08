package com.solt.balance.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.solt.balance.model.EmployeeModel;

public class LoginView implements LoginController{
	
	@FXML
	private TextField userId;
	@FXML
	private PasswordField pass;
	
	private UserHomeHandler handler;

	public void login() {
		
		
		if(EmployeeModel.getModel().getWhere(a -> {
			if(a.getName().equals(userId.getText()) 
					&& a.getPassword().equals(pass.getText())) {
				return true;
			}
			return false;
		}).size() > 0) {
			this.handler.openHome();
			userId.getScene().getWindow().hide();
			
		} else {
			// if error
			MessageView.showMessage("Error", "You need to login.", userId.getScene().getWindow());
		}
		
	}
	
	public void cancel() {
		userId.getScene().getWindow().hide();
	}

	@Override
	public void setHandler(UserHomeHandler handler) {
		this.handler = handler;
	}

}
