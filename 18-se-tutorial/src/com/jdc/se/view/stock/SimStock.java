package com.jdc.se.view.stock;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import com.jdc.se.entity.Sim;
import com.jdc.se.entity.Sim_stock;
import com.jdc.se.model.CommonModel;
import com.jdc.se.model.ModelException;
import com.jdc.se.model.SimStockModel;

public class SimStock extends AbstractStock<Sim_stock, Sim> {

	@FXML
	private TableColumn<Sim_stock, String> colDate;
	@FXML
	private TableColumn<Sim_stock, String> colIn;
	@FXML
	private TableColumn<Sim_stock, String> colTotal;
	@FXML
	private TableColumn<Sim_stock, String> colBuy;
	@FXML
	private TableColumn<Sim_stock, String> colSell;
	@FXML
	private TableColumn<Sim_stock, String> colStatus;

	@Override
	protected void init() {
		stkModel = new SimStockModel();
		entModel = new CommonModel<Sim>(Sim.class);

		colDate.setCellValueFactory(p -> {
			Sim_stock stk = p.getValue();
			if (null != stk) {
				return new SimpleStringProperty(stk.getCreation()
						.toLocalDateTime()
						.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			}
			return null;
		});
		
		colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
		colBuy.setCellValueFactory(new PropertyValueFactory<>("buy_price"));
		colSell.setCellValueFactory(new PropertyValueFactory<>("sell_price"));
		colIn.setCellValueFactory(new PropertyValueFactory<>("in"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
	}

	@Override
	protected Map<String, Object> getViewData() {
		Map<String, Object> map = new LinkedHashMap<>();
		// sim
		Sim sim = combo.getValue();
		if (null == sim) {
			throw new ModelException("Please select Sim Card.", false);
		}
		map.put("sim_id", sim.getId());

		// in
		try {
			map.put("in", Integer.parseInt(amount.getText()));
			map.put("out", 0);
		} catch (NumberFormatException e) {
			throw new ModelException("Please set amount with valid number.",
					false);
		}

		// buy
		try {
			map.put("buy_price", Integer.parseInt(buy.getText()));
		} catch (NumberFormatException e) {
			throw new ModelException("Please set amount with valid number.",
					false);
		}

		// sell
		try {
			map.put("sell_price", Integer.parseInt(sell.getText()));
		} catch (NumberFormatException e) {
			throw new ModelException("Please set amount with valid number.",
					false);
		}

		return map;
	}

	@Override
	public void loadTable() throws SQLException {
		table.getItems().clear();
		Map<String, Object> param = new LinkedHashMap<>();
		param.put("sim_id", combo.getSelectionModel().getSelectedItem().getId());
		table.getItems().addAll(stkModel.getWhere(param));
	}

	@Override
	protected boolean check(Sim_stock t) {
		return t.getStatus().equals(1);
	}

	@Override
	protected void setView() {
		Sim_stock s = table.getSelectionModel().getSelectedItem();
		combo.setDisable(true);
		amount.setText(s.getIn().toString());
		buy.setText(s.getBuy_price().toString());
		sell.setText(s.getSell_price().toString());
	}

}
