package com.jdc.shop;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.shop.data.ApplicationData;
import com.jdc.shop.data.RegistDto;

public class Home extends AbstractController implements Initializable{
	
	@FXML
	private TableView<RegistDto> table;
	@FXML
	private TableColumn<RegistDto, String> name;
	@FXML
	private TableColumn<RegistDto, String> phone;
	@FXML
	private TableColumn<RegistDto, String> address;
	@FXML
	private TableColumn<RegistDto, String> date;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		date.setCellValueFactory(p -> {
			if(p != null) {
				DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm");
				return new SimpleStringProperty(df.format(p.getValue().getDate()));
			}
			return null;
		});
		loadData();
	}

	@Override
	public void initView() {
		loadData();
	}
	
	public void loadData() {
		table.getItems().clear();
		table.getItems().addAll(ApplicationData.getRegistrationData());
	}
	

}
