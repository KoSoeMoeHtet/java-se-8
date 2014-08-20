package com.jdc.shop;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ShopHome implements Initializable{
	
	@FXML
	private StackPane view;
	@FXML
	private HBox box;
	
	private Map<String, AnchorPane> viewMap;
	private Map<String, AbstractController> controllerMap;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewMap = new HashMap<>();
		controllerMap = new HashMap<>();
		box.getChildren().filtered(t -> t instanceof Button).forEach(ShopHome.this::initNode);
		ApplicationContext.setStack(view);
		ApplicationContext.setViewMap(viewMap);
		ApplicationContext.setControllerMap(controllerMap);
		ApplicationContext.loadView("Home");
	}
	
	private void initNode(Node n) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(String.format("%s.fxml", n.getId())));
			viewMap.put(n.getId(), loader.load());
			
			controllerMap.put(n.getId(), loader.getController());
			((Button) n).setOnAction(e -> ApplicationContext.loadView(n.getId()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
