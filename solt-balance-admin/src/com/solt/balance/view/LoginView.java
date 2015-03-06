package com.solt.balance.view;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView implements Initializable{
	
	private Properties props;
	
	@FXML
	private TextField userId;
	@FXML
	private PasswordField pass;
	
	public void login() {
		
		String user = props.getProperty("login");
		String pass = props.getProperty("pass");
		
		if(user.equals(userId.getText()) && 
				pass.equals(this.pass.getText())) {
			MainApplicationView.showAppWindow(userId.getScene().getWindow());
		} else {
			// if error
			MessageView.showMessage("Error", "You need to login.", userId.getScene().getWindow());
		}
		
	}
	
	public void cancel() {
		userId.getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		props = new Properties();
		try {
			props.load(Files.newInputStream(Paths.get("user.properties"), StandardOpenOption.READ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
