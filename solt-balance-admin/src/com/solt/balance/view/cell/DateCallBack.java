package com.solt.balance.view.cell;

import java.text.SimpleDateFormat;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import com.solt.balance.model.entity.Balance;

public class DateCallBack implements Callback<TableColumn<Balance,String>, TableCell<Balance,String>>{

	@Override
	public TableCell<Balance, String> call(TableColumn<Balance, String> param) {
		return new TableCell<Balance,String>() {
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				
				Balance b = (Balance) this.getTableRow().getItem();
				if(null != b) {
					setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(b.getDate()));
				} else {
					setText(null);
				}
			};
		};
	}

}
