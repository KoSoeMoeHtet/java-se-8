package com.jdc.se.view.dialog;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AlertDialog {
	
	@FXML
	private Label title;
	@FXML
	private Label message;
	
	public static void showDialog(String title, String message, Window owner) {
		try {
			FXMLLoader loader = new FXMLLoader(AlertDialog.class.getResource("AlertDialog.fxml"));
			Parent parent = loader.load();
			AlertDialog d = loader.getController();
			d.setMessage(title, message);
			Stage stage = new Stage();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.setScene(new Scene(parent));
			stage.initOwner(owner);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMessage(String title, String message) {
		this.title.setText(title);
		this.message.setText(message);
	}
	
	public void close() {
		title.getScene().getWindow().hide();
	}

}
