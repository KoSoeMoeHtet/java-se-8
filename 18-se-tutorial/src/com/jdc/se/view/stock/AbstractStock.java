package com.jdc.se.view.stock;

import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import com.jdc.se.model.Model;
import com.jdc.se.model.ModelException;
import com.jdc.se.model.StockModel;
import com.jdc.se.view.dialog.AlertDialog;

public abstract class AbstractStock<T, K> implements Initializable {

	protected static final String UPDATE = "Update";
	protected static final String ADD = "Add";

	@FXML
	protected TableView<T> table;
	@FXML
	protected ComboBox<K> combo;
	@FXML
	protected TextField amount;
	@FXML
	protected TextField buy;
	@FXML
	protected TextField sell;
	@FXML
	protected Button add;

	protected StockModel<T> stkModel;
	protected Model<K> entModel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			// init
			this.init();
			this.combo.getItems().clear();
			this.combo.getItems().addAll(entModel.getAll());
			this.combo.getSelectionModel().select(0);

			// menu
			MenuItem edit = new MenuItem(UPDATE);
			ContextMenu menu = new ContextMenu(edit);
			table.setContextMenu(menu);

			add.setOnAction(this::add);

			edit.setOnAction(a -> {
				if (check(table.getSelectionModel().getSelectedItem())) {
					add.setText(UPDATE);
					table.setDisable(true);
					setView();
				} else {
					AlertDialog.showDialog("Warning",
							"Please select the active record. (Status = 1)",
							sell.getScene().getWindow());
				}
			});

			// load table
			this.loadTable();
		} catch (SQLException e1) {
			AlertDialog.showDialog("Error", e1.getMessage(), table.getScene()
					.getWindow());
		} catch (ModelException e1) {
			AlertDialog.showDialog("Warning", e1.getMessage(), table.getScene()
					.getWindow());
		}
	}

	protected abstract boolean check(T t);

	protected abstract void setView();

	public abstract void loadTable() throws SQLException;

	public void add(ActionEvent a) {
		try {
			Button b = (Button) a.getSource();
			if (b.getText().equals(ADD)) {
				stkModel.addStock(getViewData());
			} else {
				stkModel.updateStock(getViewData());
				add.setText(ADD);
				clear();
			}
			this.clearInputs();
			loadTable();
		} catch (SQLException e1) {
			AlertDialog.showDialog("Error", e1.getMessage(), table.getScene()
					.getWindow());
		} catch (ModelException e1) {
			AlertDialog.showDialog("Warning", e1.getMessage(), table.getScene()
					.getWindow());
		} catch (IllegalArgumentException e) {
			AlertDialog.showDialog("Error", e.getMessage(), table.getScene()
					.getWindow());
		} catch (IllegalAccessException e) {
			AlertDialog.showDialog("Error", e.getMessage(), table.getScene()
					.getWindow());
		}
	}

	public void clear() {
		this.clearTable();
		this.clearInputs();
		add.setText(ADD);
	}

	private void clearTable() {
		table.getSelectionModel().clearSelection();
		table.setDisable(false);
	}

	private void clearInputs() {
		combo.setDisable(false);
		amount.clear();
		buy.clear();
		sell.clear();
	}

	protected abstract Map<String, Object> getViewData();

	protected abstract void init();
}
