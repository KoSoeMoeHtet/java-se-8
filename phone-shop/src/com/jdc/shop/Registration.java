package com.jdc.shop;

import com.jdc.shop.data.ApplicationData;
import com.jdc.shop.data.NeedToAlertException;
import com.jdc.shop.data.RegistDto;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Registration extends AbstractController{
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private TextArea address;

	public void clear() {
		name.clear();
		phone.clear();
		address.clear();
	}
	
	public void regist() {
		try {
			RegistDto dto = new RegistDto(name.getText(), phone.getText(), address.getText());
			ApplicationData.addData(dto);
			ApplicationContext.loadView("Home");
		} catch (NeedToAlertException e) {
			
		}
	}

	@Override
	public void initView() {
		clear();
	}
	
}
