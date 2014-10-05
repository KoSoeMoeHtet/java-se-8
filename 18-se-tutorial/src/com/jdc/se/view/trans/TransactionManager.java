package com.jdc.se.view.trans;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import com.jdc.se.entity.Division;
import com.jdc.se.entity.Phone;
import com.jdc.se.entity.Sim;
import com.jdc.se.entity.Township;
import com.jdc.se.entity.Transaction;
import com.jdc.se.model.CommonModel;

public class TransactionManager implements Initializable {
	
	@FXML
	private TextField id;
	@FXML
	private TextField name;
	@FXML
	private TextField nrc;
	@FXML
	private TextField phone;
	@FXML
	private ComboBox<Division> divisions;
	@FXML
	private ComboBox<Phone> phones;
	@FXML
	private ComboBox<Sim> sims;
	@FXML
	private DatePicker dateFrom;
	@FXML
	private DatePicker dateTo;

	@FXML
	private TableView<Transaction> table;
	@FXML
	private TableColumn<Transaction, String> colId;
	@FXML
	private TableColumn<Transaction, String> colCreation;
	@FXML
	private TableColumn<Transaction, String> colCustomer;
	@FXML
	private TableColumn<Transaction, String> colPhone;
	@FXML
	private TableColumn<Transaction, String> colSim;
	@FXML
	private TableColumn<Transaction, String> colTotal;
	
	private CommonModel<Division> divModel;
	private CommonModel<Transaction> transModel;
	private CommonModel<Sim> simModel;
	private CommonModel<Phone> phoneModel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		divModel = new CommonModel<Division>(Division.class);
		transModel = new CommonModel<Transaction>(Transaction.class);
		simModel = new CommonModel<Sim>(Sim.class);
		phoneModel = new CommonModel<Phone>(Phone.class);
		
		try {
			this.loadCombo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadCombo() throws SQLException {
		this.divisions.getItems().clear();
		this.divisions.getItems().addAll(divModel.getAll());

		this.sims.getItems().clear();
		this.sims.getItems().addAll(simModel.getAll());

		this.phones.getItems().clear();
		this.phones.getItems().addAll(phoneModel.getAll());

	}
	
}
