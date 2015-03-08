package com.solt.balance.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainApplicationView implements Initializable {

	@FXML
	private MenuItem close;
	@FXML
	private Menu edit;
	@FXML
	private Menu meta;
	@FXML
	private Menu open;
	@FXML
	private StackPane pane;

	@FXML
	private Label message;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// close
		close.setOnAction(a -> message.getScene().getWindow().hide());

		// register edit menu
		for (MenuItem m : edit.getItems()) {
			m.setOnAction(this::loadView);
		}

		// register open menu
		for (MenuItem m : open.getItems()) {
			m.setOnAction(this::loadView);
		}

		// register open menu
		for (MenuItem m : meta.getItems()) {
			m.setOnAction(this::loadView);
		}

		this.home();
	}

	public void loadView(ActionEvent e) {
		try {
			MenuItem item = (MenuItem) e.getSource();
			
			String fileName = String.format("%s.fxml", item.getText().replaceAll(" ", ""));
			
			pane.getChildren().clear();
			pane.getChildren().add(FXMLLoader.load(getClass().getResource(fileName)));

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void showAppWindow(Window onwer) {

		try {
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(onwer);

			stage.setScene(new Scene(FXMLLoader.load(MainApplicationView.class
					.getResource("MainApplicationView.fxml"))));
			
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void home() {
		try {
			pane.getChildren().clear();
			pane.getChildren().add(FXMLLoader.load(getClass().getResource("Home.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
