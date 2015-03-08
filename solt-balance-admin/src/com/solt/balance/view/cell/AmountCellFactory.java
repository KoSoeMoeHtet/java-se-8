package com.solt.balance.view.cell;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import com.solt.balance.model.entity.Balance;

public class AmountCellFactory implements Callback<TableColumn<Balance,String>, TableCell<Balance,String>>{
	
	private boolean in;
	
	public AmountCellFactory(boolean in) {
		this.in = in;
	}

	@Override
	public TableCell<Balance, String> call(TableColumn<Balance, String> param) {
		return new TableCell<Balance, String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				
				Balance b = (Balance) getTableRow().getItem();
				
				if(null != b) {
					if(in) {
						if(b.getCategory().getType().equals("IN")) {
							setText(String.valueOf(b.getAmount()));
						}
					} else {
						if(b.getCategory().getType().equals("OUT")) {
							setText(String.valueOf(b.getAmount()));
						}
					}
				} else {
					setText(null);
				}
			}
		};
	}

}
