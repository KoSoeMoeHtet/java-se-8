package com.jdc.se.view.master;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import com.jdc.se.entity.Division;
import com.jdc.se.entity.Township;
import com.jdc.se.model.DivisionModel;
import com.jdc.se.model.ModelException;
import com.jdc.se.model.TownshipModel;

public class TownshipMaster implements Initializable,
		Callback<CellDataFeatures<Township, String>, ObservableValue<String>> {

	@FXML
	private ComboBox<Division> combo;
	@FXML
	private TableView<Township> table;
	@FXML
	private TableColumn<Township, String> colId;
	@FXML
	private TableColumn<Township, String> colName;
	@FXML
	private TableColumn<Township, String> colDivision;
	@FXML
	private TextField name;

	private TownshipModel tm;
	private DivisionModel dm;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			colId.setCellValueFactory(new PropertyValueFactory<>("id"));
			colName.setCellValueFactory(new PropertyValueFactory<>("name"));
			colDivision.setCellValueFactory(this);

			tm = new TownshipModel();
			dm = new DivisionModel();

			combo.getItems().clear();
			combo.getItems().addAll(dm.getAll());

			this.reload();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		try {
			this.tm.insert(this.getViewParam());
			this.reload();
		} catch (ModelException e) {
			// TODO Alert Dialog
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Map<String, Object> getViewParam() {
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

	public void delete(ActionEvent e) {

	}

	public void clear() {

	}

	public void edit(ActionEvent e) {

	}

	private void reload() throws SQLException {
		table.getItems().clear();
		table.getItems().addAll(tm.getAll());
	}

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

}
