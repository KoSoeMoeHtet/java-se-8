package com.jdc.se.view.master;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;

import com.jdc.se.model.Model;
import com.jdc.se.model.ModelException;
import com.jdc.se.view.dialog.AlertDialog;

public abstract class AbstractMasterController<T> implements Initializable{
	
	private static final String ADD = "Add";
	private static final String SAVE = "Save";
	
	@FXML
	protected TableView<T> table;
	@FXML
	protected Button add;
	@FXML
	protected Button clear;
	
	protected Model<T> model;
	
	protected abstract Object getSelectId();
	protected abstract Map<String, Object> getViewParam();
	protected abstract void setView(T t);
	protected abstract void clear();
	protected abstract void init(); 
	
	public void clear(ActionEvent e) {
		add.setText(ADD);
		table.setDisable(false);
		this.clear();
	}
	
	public void update(ActionEvent e) {
		table.setDisable(true);
		this.setView(table.getSelectionModel().getSelectedItem());
		add.setText(SAVE);
	}


	public void delete(ActionEvent e) {
		try {
			model.delete(getId());
			this.loadTable();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
	
	private Map<String, Object> getId() {
		Map<String, Object> param = new LinkedHashMap<>();
		param.put("id", this.getSelectId());
		return param;
	}

	protected void loadTable() throws SQLException {
		table.getItems().clear();
		table.getItems().addAll(model.getAll());
	}
	
	public void add(ActionEvent e) {
		try {
			Button b = (Button) e.getSource();
			Map<String, Object> param =getViewParam();
			if(null != param) {
				if(ADD.equals(b.getText())) {
					model.insert(getViewParam());
				} else {
					model.update(getViewParam(), getId());
				}
				this.clear(e);
				this.loadTable();
			}
		} catch (SQLException e1) {
			AlertDialog.showDialog("Error", e1.getMessage(), table.getScene().getWindow());
		} catch (ModelException e1) {
			AlertDialog.showDialog("Warning", e1.getMessage(), table.getScene().getWindow());
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// init
		this.init();

		ContextMenu ctx = new ContextMenu();
		MenuItem delete = new MenuItem("Delete");
		MenuItem update = new MenuItem("Update");
		ctx.getItems().addAll(update, delete);
		
		// delete
		delete.setOnAction(this::delete);
		// update
		update.setOnAction(this::update);
		
		// clear
		clear.setOnAction(this::clear);
		// add
		add.setOnAction(this::add);
		
		table.setContextMenu(ctx);
		
		
		try {
			this.loadTable();
		} catch (SQLException e) {
			AlertDialog.showDialog("Error", e.getMessage(), table.getScene().getWindow());
		}
	}
}
