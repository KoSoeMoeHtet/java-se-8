package com.jdc.shop;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.shop.model.ModalManager;
import com.jdc.shop.model.ModelType;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;
import com.jdc.shop.model.Township;

public class ShopFrame implements Initializable {

	private RegistrationModel model;
	private ModelType type = ModelType.NIO;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = ModalManager.getRegistrationModel(type);
		ToggleGroup group = new ToggleGroup();
		group.getToggles().addAll(male, female);

		// registration table
		regName.setCellValueFactory(new PropertyValueFactory<>("name"));
		regNrc.setCellValueFactory(new PropertyValueFactory<>("nrc"));
		regAddress.setCellValueFactory(this::call);

		// sell table
		selName.setCellValueFactory(new PropertyValueFactory<>("name"));
		selNrc.setCellValueFactory(new PropertyValueFactory<>("nrc"));
		selAddress.setCellValueFactory(this::call);
		selCard.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));

		this.initViewInputs();
	}

	public void initViewInputs() {
		message.setText("");
		// date inputs
		dtFrom.setValue(LocalDate.now());
		dtTo.setValue(LocalDate.now());

		// registration table
		regTable.getItems().clear();
		regTable.getItems().addAll(
				model.getRegistrationData(convertFrom(dtFrom.getValue()),
						convertTo(dtTo.getValue())));
		// sell table
		selTable.getItems().clear();
		selTable.getItems().addAll(model.getSoldData());

		name.clear();
		male.setSelected(true);
		nrc.clear();
		address.clear();

		dob.setValue(LocalDate.now());

		// township
		township.getItems().clear();
		township.getItems().addAll(ModalManager.getTownshipModel(type).getTownships());
	}

	public void register() {
		try {
			// check input
			String strName = name.getText();
			String strNrc = nrc.getText();

			if (null == strName || null == strNrc || strName.isEmpty()
					|| strNrc.isEmpty()) {
				throw new ShopAppException("Pleace set Name and Nrc Number.");
			}

			// get view data
			Registration regist = new Registration(strName, male.isSelected(),
					strNrc, convertFrom(dob.getValue()), address.getText(),
					township.getValue());

			// insert into model
			model.create(regist);

			// init view
			initViewInputs();
		} catch (ShopAppException e) {
			message.setText(e.getMessage());
		}
	}

	public void sell() {
		try {
			// udpate card number
			model.update(convertFrom(dtFrom.getValue()),
					convertTo(dtTo.getValue()));
			// init view
			initViewInputs();
		} catch (ShopAppException e) {
			message.setText(e.getMessage());
		}
	}

	private ObservableValue<String> call(
			CellDataFeatures<Registration, String> param) {
		if (null != param) {
			Registration r = param.getValue();
			if (null != r && null != r.getTownship()) {
				return new SimpleStringProperty(String.format("%s, %s",
						r.getAddress(), r.getTownship().getName()));
			}

			if (null != r) {
				return new SimpleStringProperty(r.getAddress());
			}
		}
		return null;
	}

	private Date convertTo(LocalDate date) {
		LocalDateTime dt = LocalDateTime.of(date, LocalTime.of(23, 59));
		ZonedDateTime zdt = dt.atZone(ZoneId.systemDefault());
		return Date.from(zdt.toInstant());
	}

	private Date convertFrom(LocalDate date) {
		LocalDateTime dt = LocalDateTime.of(date, LocalTime.of(00, 00));
		ZonedDateTime zdt = dt.atZone(ZoneId.systemDefault());
		return Date.from(zdt.toInstant());
	}

	// registration table
	@FXML
	private TableView<Registration> regTable;
	@FXML
	private TableColumn<Registration, String> regName;
	@FXML
	private TableColumn<Registration, String> regNrc;
	@FXML
	private TableColumn<Registration, String> regAddress;

	@FXML
	private DatePicker dtFrom;
	@FXML
	private DatePicker dtTo;

	// sell table
	@FXML
	private TableView<Registration> selTable;
	@FXML
	private TableColumn<Registration, String> selName;
	@FXML
	private TableColumn<Registration, String> selNrc;
	@FXML
	private TableColumn<Registration, String> selAddress;
	@FXML
	private TableColumn<Registration, String> selCard;

	@FXML
	private TextField name;
	@FXML
	private RadioButton male;
	@FXML
	private RadioButton female;
	@FXML
	private TextField nrc;
	@FXML
	private DatePicker dob;
	@FXML
	private TextArea address;
	@FXML
	private ComboBox<Township> township;
	@FXML
	private Label message;
}
