package com.jdc.shop;

import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.shop.data.ApplicationData;
import com.jdc.shop.data.NeedToAlertException;
import com.jdc.shop.data.RegistDto;

public class Sell extends AbstractController implements Initializable{

	@FXML
	private TableView<RegistDto> table;
	@FXML
	private TableColumn<RegistDto, String> cardNum;
	@FXML
	private TableColumn<RegistDto, String> name;
	@FXML
	private TableColumn<RegistDto, String> phone;
	@FXML
	private TableColumn<RegistDto, String> address;

	@Override
	public void initView() {
		table.getItems().clear();
	}

	public void generate() {
		try {

			String lastNumber = ApplicationData.getLastCardNumber();
			final Map<String, String> keyMap = new HashMap<>();
			keyMap.put("cardNumber", ApplicationData.nextCardNumber(lastNumber));
			
			// get registration
			List<RegistDto> list = ApplicationData.getRegistrationData(5).stream().map(e -> {
				try {
					RegistDto d = e.clone();
					d.setCardNum(new String(keyMap.get("cardNumber")));
					keyMap.put("cardNumber", e.getCardNum());
					return d;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				return e;
			}).collect(Collectors.toList());
			
			table.getItems().clear();
			table.getItems().addAll(list);
			
		} catch (ParseException e) {
			throw new NeedToAlertException(e.getMessage());
		}
	}

	public void sell() {
		table.getItems().forEach(d -> {
			ApplicationData.addSellData(d);
		});
		
		ApplicationContext.loadView("SoldOut");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cardNum.setCellValueFactory(new PropertyValueFactory<>("cardNum"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
	}

}
