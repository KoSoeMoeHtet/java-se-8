package com.jdc.se.view.master;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MasterMenu implements Initializable{
	
	@FXML
	private StackPane stack;
	@FXML
	private AnchorPane pane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			
			for(Node n : pane.getChildren()) {
				if(n instanceof Button) {
					Button b = (Button)n;
					b.setOnAction(MasterMenu.this::showPage);
				}
			}
			
			this.load("Division Master");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showPage(ActionEvent e) {
		try {
			Button b = (Button)e.getSource();
			this.load(String.format("%s %s", b.getText(), "Master"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void load(String view) throws IOException {
		Parent parent = FXMLLoader.load(MasterMenu.class.getResource(view.replaceAll(" ", "") + ".fxml"));
		stack.getChildren().clear();
		stack.getChildren().add(parent);
	}

}
