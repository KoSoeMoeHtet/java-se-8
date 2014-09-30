package com.jdc.se.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Model<T> {

	public int insert(Map<String, Object> params) throws SQLException;
	public int update(Map<String, Object> set, Map<String, Object> where) throws SQLException;
	public List<T> getAll() throws SQLException;
	public T findById(Map<String, Object> where) throws SQLException;
	public List<T> getWhere(Map<String, Object> where) throws SQLException;
	public int delete(Map<String, Object> where) throws SQLException;
}
