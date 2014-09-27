package com.jdc.se.view.master;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class MasterMenu implements Initializable{
	
	@FXML
	private StackPane stack;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			this.load("Division Master");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void load(String view) throws IOException {
		Parent parent = FXMLLoader.load(MasterMenu.class.getResource(view.replaceAll(" ", "") + ".fxml"));
		stack.getChildren().clear();
		stack.getChildren().add(parent);
	}

}
