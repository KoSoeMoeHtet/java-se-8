package com.jdc.se.view.main;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.jdc.se.view.cust.CustomerManager;
import com.jdc.se.view.master.MasterMenu;
import com.jdc.se.view.stock.StockManagement;
import com.jdc.se.view.trans.TransactionManager;

public class TutorialMain {

	@FXML
	private Button btn;

	public void showMaster() {
		try {
			this.load("Master Menu", MasterMenu.class
					.getResource("MasterMenu.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showTransaction() {
		try {
			this.load("Transaction Management", TransactionManager.class
					.getResource("TransactionManager.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showCustomer() {
		try {
			this.load("Customer Management", CustomerManager.class
					.getResource("CustomerManager.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showStock() {
		try {
			this.load("Stock Management",
					StockManagement.class.getResource("StockManagement.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void load(String title, URL fxml) throws IOException {
		Stage stage = new Stage();
		Parent parent = FXMLLoader.load(fxml);
		stage.setScene(new Scene(parent));

		stage.setTitle(title);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btn.getScene().getWindow());
		stage.show();
	}

}
