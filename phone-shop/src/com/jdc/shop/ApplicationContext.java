package com.jdc.shop;

import java.util.Map;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ApplicationContext {
	
	private static Map<String, AnchorPane> viewMap;
	private static Map<String, AbstractController> controllerMap;
	
	private static StackPane stack;
	

	public static void setViewMap(Map<String, AnchorPane> viewMap) {
		ApplicationContext.viewMap = viewMap;
	}

	public static void setStack(StackPane stack) {
		ApplicationContext.stack = stack;
	}
	
	
	public static void loadView(String viewId) {
		controllerMap.get(viewId).initView();
		stack.getChildren().clear();
		stack.getChildren().add(viewMap.get(viewId));
	}

	public static void setControllerMap (
			Map<String, AbstractController> controllerMap) {
		ApplicationContext.controllerMap = controllerMap;
	}

}
