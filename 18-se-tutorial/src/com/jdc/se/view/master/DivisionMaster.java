package com.jdc.se.view.master;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.se.entity.Division;
import com.jdc.se.model.DivisionModel;
import com.jdc.se.view.dialog.AlertDialog;

public class DivisionMaster extends AbstractMasterController<Division> implements Initializable {

	@FXML
	private TextField name;
	@FXML
	private TableColumn<Division, String> colId;
	@FXML
	private TableColumn<Division, String> colName;
	

	@Override
	protected Object getSelectId() {
		Division d = table.getSelectionModel().getSelectedItem();
		if(null != d)
			return d.getId();
		
		return null;
	}


	@Override
	protected Map<String, Object> getViewParam() {
		if(name.getText().trim().isEmpty()) {
			AlertDialog.showDialog("Warning", "Please set name input.", name.getScene().getWindow());
		} else {
			Map<String, Object> param = new LinkedHashMap<>();
			param.put("name", name.getText());
			return param;
		}
		return null;
	}


	@Override
	protected void setView(Division t) {
		name.setText(t.getName());
	}


	@Override
	protected void clear() {
		name.clear();
	}


	@Override
	protected void init() {
		model = new DivisionModel();
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
	}
	
}
