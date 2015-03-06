package com.solt.balance.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import com.solt.balance.model.CategoryModel;
import com.solt.balance.model.entity.Category;

public class CategoryAdmin implements Initializable {

	@FXML
	private TableView<Category> catTable;
	@FXML
	private TableColumn<String, Category> catIdCol;
	@FXML
	private TableColumn<String, Category> catNameCol;
	@FXML
	private TableColumn<String, Category> catTypeCol;
	@FXML
	private TextField category;
	@FXML
	private ComboBox<String> catCobo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			catIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
			catNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			catTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

			catCobo.getItems().clear();
			catCobo.getItems().addAll("IN", "OUT");

			this.reloadTable();
		} catch (IOException e) {
			MessageView.showMessage("Error",
					e.getMessage(), category
							.getScene().getWindow());
		}

	}

	public void addCategory() {
		try {
			// get data from view
			Category c = new Category();
			c.setName(category.getText());
			c.setType(catCobo.getSelectionModel().getSelectedItem());

			// check data
			if (c.getName() == null || c.getName().isEmpty()
					|| c.getType() == null || c.getType().isEmpty()) {
				MessageView.showMessage("Message",
						"Please set input fields correctly.", category
								.getScene().getWindow());
			} else {
				// add to file
				CategoryModel cm = CategoryModel.getModel();
				cm.add(c);

				// reload table
				this.reloadTable();
			}
		} catch (IOException e) {
			MessageView.showMessage("Error",
					e.getMessage(), category
							.getScene().getWindow());
		}

	}

	private void reloadTable() throws IOException {
		CategoryModel cm = CategoryModel.getModel();
		catTable.getItems().clear();
		catTable.getItems().addAll(cm.getAll());
	}

}
