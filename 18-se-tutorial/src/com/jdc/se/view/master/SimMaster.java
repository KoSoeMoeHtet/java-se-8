package com.jdc.se.view.master;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.se.entity.Sim;
import com.jdc.se.model.CommonModel;
import com.jdc.se.model.ModelException;

public class SimMaster extends AbstractMasterController<Sim> implements Initializable {

	@FXML
	private TextField name;
	@FXML
	private TextField type;
	@FXML
	private TextField company;
	@FXML
	private TableColumn<Sim, String> colId;
	@FXML
	private TableColumn<Sim, String> colName;
	@FXML
	private TableColumn<Sim, String> colType;
	@FXML
	private TableColumn<Sim, String> colCompany;
	

	@Override
	protected Object getSelectId() {
		Sim d = table.getSelectionModel().getSelectedItem();
		if(null != d)
			return d.getId();
		
		return null;
	}


	@Override
	protected Map<String, Object> getViewParam() {
		String strName = name.getText();
		String strType = type.getText();
		String strCompany = company.getText();
		
		if (strName.isEmpty()) {
			throw new ModelException("Please set township name.", false);
		}

		if (strType.isEmpty()) {
			throw new ModelException("Please set Sim Card Type.", false);
		}

		if (strCompany.isEmpty()) {
			throw new ModelException("Please set Company name.", false);
		}
		Map<String, Object> param = new LinkedHashMap<>();
		param.put("name", strName);
		param.put("type", strType);
		param.put("company", strCompany);
		return param;
	}


	@Override
	protected void setView(Sim t) {
		name.setText(t.getName());
		type.setText(t.getType());
		company.setText(t.getCompany());
	}


	@Override
	protected void clear() {
		name.clear();
		type.clear();
		company.clear();
	}


	@Override
	protected void init() {
		model = new CommonModel<Sim>(Sim.class);
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colType.setCellValueFactory(new PropertyValueFactory<>("type"));
		colCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
	}
	
}
