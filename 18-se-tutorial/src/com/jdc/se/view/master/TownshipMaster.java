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

import com.jdc.se.entity.Division;
import com.jdc.se.entity.Township;
import com.jdc.se.model.DivisionModel;
import com.jdc.se.model.ModelException;
import com.jdc.se.model.TownshipModel;

public class TownshipMaster extends AbstractMasterController<Township> implements 
		Callback<CellDataFeatures<Township, String>, ObservableValue<String>> {

	@FXML
	private ComboBox<Division> combo;
	@FXML
	private TableColumn<Township, String> colId;
	@FXML
	private TableColumn<Township, String> colName;
	@FXML
	private TableColumn<Township, String> colDivision;
	@FXML
	private TextField name;

	private DivisionModel dm;

	@Override
	public ObservableValue<String> call(CellDataFeatures<Township, String> param) {
		if(null != param) {
			Integer dId = param.getValue().getDivision_id();
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
		Township t = table.getSelectionModel().getSelectedItem();
		if(null != t) {
			return t.getId();
		}
		return null;
	}

	@Override
	protected Map<String, Object> getViewParam() {
		Map<String, Object> param = new LinkedHashMap<>();
		Division d = combo.getSelectionModel().getSelectedItem();
		String strName = name.getText().trim();

		if (null == d) {
			throw new ModelException("Please select division.", false);
		}

		if (strName.isEmpty()) {
			throw new ModelException("Please set township name.", false);
		}

		param.put("name", strName);
		param.put("division_id", d.getId());

		return param;
	}

	@Override
	protected void setView(Township t) {
		name.setText(t.getName());
		
		Division d = combo.getItems().stream()
				.filter(a -> a.getId() == t.getDivision_id())
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
			colDivision.setCellValueFactory(this);

			model = new TownshipModel();
			dm = new DivisionModel();

			combo.getItems().clear();
			combo.getItems().addAll(dm.getAll());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void clear() {
		name.clear();
		combo.getSelectionModel().clearSelection();
	}

}
