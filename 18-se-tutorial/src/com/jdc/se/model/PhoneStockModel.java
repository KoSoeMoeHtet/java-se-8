package com.jdc.se.model;

import java.sql.SQLException;
import java.util.Map;

import com.jdc.se.entity.Phone_stock;

public class PhoneStockModel extends CommonModel<Phone_stock> implements StockModel<Phone_stock>{

	public PhoneStockModel() {
		super(Phone_stock.class);
	}

	@Override
	public void addStock(Map<String, Object> param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStock(Map<String, Object> param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
