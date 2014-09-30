package com.jdc.se.view.master;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import com.jdc.se.entity.Phone;
import com.jdc.se.entity.Phone_maker;
import com.jdc.se.model.ModelException;
import com.jdc.se.model.PhoneMakerModel;
import com.jdc.se.model.PhoneModel;

public class PhoneMaster extends AbstractMasterController<Phone> implements 
		Callback<CellDataFeatures<Phone, String>, ObservableValue<String>> {

	@FXML
	private ComboBox<Phone_maker> combo;
	@FXML
	private TableColumn<Phone, String> colId;
	@FXML
	private TableColumn<Phone, String> colName;
	@FXML
	private TableColumn<Phone, String> colMaker;
	@FXML
	private TableColumn<Phone, String> colMemory;
	@FXML
	private TableColumn<Phone, String> colModel;
	@FXML
	private TableColumn<Phone, String> colColor;
	@FXML
	private TextField name;
	@FXML
	private TextField memory;
	@FXML
	private TextField pmodel;
	@FXML
	private TextField color;

	private PhoneMakerModel dm;

	@Override
	public ObservableValue<String> call(CellDataFeatures<Phone, String> param) {
		if(null != param) {
			Integer dId = param.getValue().getPhone_maker_id();
			String str = combo.getItems().stream()
					.filter(a -> a.getId() == dId)
					.map(a -> a.getName())
					.findAny().get();
			return new SimpleStringProperty(str);
		}
		return new SimpleStringProperty("");
	}

	@Override
	protected Object getSelectId() {
		Phone t = table.getSelectionModel().getSelectedItem();
		if(null != t) {
			return t.getId();
		}
		return null;
	}

	@Override
	protected Map<String, Object> getViewParam() {
		Map<String, Object> param = new LinkedHashMap<>();
		Phone_maker d = combo.getSelectionModel().getSelectedItem();
		String strName = name.getText().trim();
		String strModel = pmodel.getText().trim();
		String strMemory = memory.getText().trim();
		String strColor = color.getText().trim();
		
		if (null == d) {
			throw new ModelException("Please select phone maker.", false);
		}

		if (strName.isEmpty()) {
			throw new ModelException("Please set township name.", false);
		}

		if (strModel.isEmpty()) {
			throw new ModelException("Please set model number.", false);
		}

		if (strMemory.isEmpty()) {
			throw new ModelException("Please set memory ammount.", false);
		}
		
		param.put("name", strName);
		param.put("phone_maker_id", d.getId());
		param.put("model", strModel);
		param.put("memory", strMemory);
		param.put("color", strColor);

		return param;
	}

	@Override
	protected void setView(Phone t) {
		name.setText(t.getName());
		memory.setText(t.getMemory());
		pmodel.setText(t.getModel());
		color.setText(t.getColor());
		
		Phone_maker d = combo.getItems().stream()
				.filter(a -> a.getId() == t.getPhone_maker_id())
				.findAny().get();
		
		if(null != d) {
			combo.getSelectionModel().select(d);
		}
	}

	@Override
	protected void init() {
		try {
			colId.setCellValueFactory(new PropertyValueFactory<>("id"));
			colName.setCellValueFactory(new PropertyValueFactory<>("name"));
			colMemory.setCellValueFactory(new PropertyValueFactory<>("memory"));
			colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
			colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
			colMaker.setCellValueFactory(this);

			model = new PhoneModel();
			dm = new PhoneMakerModel();

			combo.getItems().clear();
			combo.getItems().addAll(dm.getAll());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void clear() {
		name.clear();
		color.clear();
		memory.clear();
		pmodel.clear();
		combo.getSelectionModel().clearSelection();
	}

}
