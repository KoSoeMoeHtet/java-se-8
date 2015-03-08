package com.solt.balance.view;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.solt.balance.model.EmployeeModel;


public class Main extends Application implements UserHomeHandler {
	@Override
	public void start(Stage primaryStage) {
		try {

			// get employee count
			int count = EmployeeModel.getModel().size();
			
			// signup page
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
			
			if(count > 0) {
				loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
			}
			Parent p = loader.load();
			
			LoginController controller = loader.getController();
			controller.setHandler(this);
			
			primaryStage.setScene(new Scene(p));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void openHome() {
		try {
			Stage stage = new Stage();
			Parent p = FXMLLoader.load(getClass().getResource("MainApplicationView.fxml"));
			stage.setScene(new Scene(p));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
