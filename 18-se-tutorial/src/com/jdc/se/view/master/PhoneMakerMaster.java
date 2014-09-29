package com.jdc.se.view.master;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.se.entity.Phone_maker;
import com.jdc.se.model.PhoneMakerModel;

public class PhoneMakerMaster extends AbstractMasterController<Phone_maker> implements Initializable {

	@FXML
	private TextField name;
	@FXML
	private TableColumn<Phone_maker, String> colId;
	@FXML
	private TableColumn<Phone_maker, String> colName;
	

	@Override
	protected Object getSelectId() {
		Phone_maker d = table.getSelectionModel().getSelectedItem();
		if(null != d)
			return d.getId();
		
		return null;
	}


	@Override
	protected Map<String, Object> getViewParam() {
		Map<String, Object> param = new LinkedHashMap<>();
		param.put("name", name.getText());
		return param;
	}


	@Override
	protected void setView(Phone_maker t) {
		name.setText(t.getName());
	}


	@Override
	protected void clear() {
		name.clear();
	}


	@Override
	protected void init() {
		model = new PhoneMakerModel();
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
	}
	
}
