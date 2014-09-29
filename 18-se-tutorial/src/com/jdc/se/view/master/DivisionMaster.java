package com.jdc.se.view.master;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.se.entity.Division;
import com.jdc.se.model.DivisionModel;

public class DivisionMaster implements Initializable {

	private static final String ADD = "Add";
	private static final String SAVE = "Save";
	
	@FXML
	private TextField name;
	@FXML
	private TableView<Division> table;
	@FXML
	private TableColumn<Division, String> colId;
	@FXML
	private TableColumn<Division, String> colName;

	@FXML
	private Button clear;
	@FXML
	private Button add;
	
	private DivisionModel dm;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			// define columns
			colId.setCellValueFactory(new PropertyValueFactory<>("id"));
			colName.setCellValueFactory(new PropertyValueFactory<>("name"));

			dm = new DivisionModel();

			// add event handler
			add.setOnAction(e -> {
				try {
					Button b = (Button)e.getSource();
					if(b.getText().equals(ADD)) {
						Map<String, Object> params = new LinkedHashMap<>();
						params.put("name", name.getText());
						dm.insert(params);
					} else {
						Division d = table.getSelectionModel().getSelectedItem();
						if(!d.getName().equals(name.getText())) {
							Map<String, Object> params = new LinkedHashMap<>();
							params.put("name", name.getText());
							
							Map<String, Object> where = new LinkedHashMap<>();
							where.put("id", d.getId());
							
							dm.update(params, where);
						}
						name.clear();
						table.setDisable(false);
						add.setText(ADD);
					}
 					reload();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			clear.setOnAction(e -> {
				name.clear();
			});

			// load data
			this.reload();
			
			// delete
			ContextMenu ctx = new ContextMenu();
			MenuItem delete = new MenuItem("Delete");
			MenuItem update = new MenuItem("Update");
			ctx.getItems().addAll(update, delete);
			
			delete.setOnAction(e -> {
				try {
					Division d = table.getSelectionModel().getSelectedItem();
					Map<String, Object> param = new LinkedHashMap<>();
					param.put("id", d.getId());
					dm.delete(param);
					reload();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			// update
			update.setOnAction(e -> {
				Division d = table.getSelectionModel().getSelectedItem();
				name.setText(d.getName());
				add.setText(SAVE);
				table.setDisable(true);
			});
			
			table.setContextMenu(ctx);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void reload() throws SQLException {
		table.getItems().clear();
		table.getItems().addAll(dm.getAll());
	}

}
