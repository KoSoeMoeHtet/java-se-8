package com.jdc.se.view.main;

import java.io.IOException;

import com.jdc.se.view.master.MasterMenu;
import com.jdc.se.view.stock.StockManagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TutorialMain {
	
	@FXML
	private Button btn; 
	
	public void showMaster() {
		try {
			Stage stage = new Stage();
			Parent parent = FXMLLoader.load(MasterMenu.class.getResource("MasterMenu.fxml"));
			stage.setScene(new Scene(parent));
			
			stage.setTitle("Master Menu");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(btn.getScene().getWindow());
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showTransaction() {
		
	}
	
	public void showCustomer() {
		
	}
	
	public void showStock() {
		try {
			Stage stage = new Stage();
			Parent parent = FXMLLoader.load(StockManagement.class.getResource("StockManagement.fxml"));
			stage.setScene(new Scene(parent));
			
			stage.setTitle("Stock Management");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(btn.getScene().getWindow());
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
