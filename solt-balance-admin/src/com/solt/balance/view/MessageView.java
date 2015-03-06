package com.solt.balance.view;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MessageView {

	@FXML
	private Label messageType;
	@FXML
	private TextArea message;

	public void close() {
		message.getScene().getWindow().hide();
	}

	public void setMessage(String type, String message) {
		this.messageType.setText(type);
		this.message.setText(message);
	}

	public static void showMessage(String type, String message, Window owner) {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Scene scene = new Scene(loader.load(Files.newInputStream(
					Paths.get(MessageView.class.getResource("MessageView.fxml").toURI()))));

			MessageView view = loader.getController();
			view.setMessage(type, message);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(owner);
			stage.show();

		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
