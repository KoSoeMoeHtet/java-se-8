package com.jdc.se.view.stock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;

public class StockManagement implements Initializable{
	
	@FXML
	private ToggleButton phone;
	@FXML
	private ToggleButton sim;
	@FXML
	private StackPane pane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		phone.setOnAction(a -> load());
		sim.setOnAction(a -> load());
		
		this.load();
	}
	
	public void load() {
		
		try {

			String view = "%sStock.fxml";
			if(phone.isSelected()) {
				view = String.format(view, "Phone");
			} else {
				view = String.format(view, "Sim");
			}
			
			pane.getChildren().clear();
			pane.getChildren().add(FXMLLoader.load(this.getClass().getResource(view)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
