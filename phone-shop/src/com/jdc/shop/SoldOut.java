package com.jdc.shop;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import com.jdc.shop.data.ApplicationData;
import com.jdc.shop.data.RegistDto;

public class SoldOut extends AbstractController implements Initializable {

	@FXML
	private TableView<RegistDto> table;
	@FXML
	private TableColumn<RegistDto, String> cardNum;
	@FXML
	private TableColumn<RegistDto, String> name;
	@FXML
	private TableColumn<RegistDto, String> phone;
	@FXML
	private TableColumn<RegistDto, String> date;
	@FXML
	private AnchorPane view;
	
	@Override
	public void initView() {
		table.getItems().clear();
		table.getItems().addAll(ApplicationData.getSellData());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cardNum.setCellValueFactory(new PropertyValueFactory<>("cardNum"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		date.setCellValueFactory(e -> {
			if (e != null) {
				return new SimpleStringProperty(new SimpleDateFormat(
						"yyyyMMdd HH:mm").format(e.getValue().getDate()));
			}
			return null;
		});
	}
	
}
