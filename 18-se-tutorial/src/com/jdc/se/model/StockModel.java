package com.jdc.se.model;

import java.sql.SQLException;
import java.util.Map;

public interface StockModel<T> extends Model<T>{

	public void addStock(Map<String, Object> param) throws SQLException;
	public void updateStock(Map<String, Object> param) throws SQLException, IllegalArgumentException, IllegalAccessException;
}
