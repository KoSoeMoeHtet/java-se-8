package com.jdc.se.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class AbstractModel<T> {
	
	private static Connection CONN;
	
	private static String INSERT = "insert into %s (%s) values (%s)";
	private static String UPDATE = "update %s set %s %s";
	private static String SELECT = "select * from %s %s";
	private static String DELETE = "delete from %s %s";
	
	private Class<T> clz;
	protected boolean creation = false;
	protected boolean modification = false; 
	
	public AbstractModel(Class<T> clz) {
		super();
		this.clz = clz;
	}

	public int insert(Map<String, Object> params) throws SQLException {
		String sql = String.format(INSERT, clz.getSimpleName().toLowerCase(),
				this.getInsertColumns(params),
				this.getInsertValues(params));
		System.out.println(sql);
		Connection conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);

		int count = 0;
		
		List<String> keys = new ArrayList<>(params.keySet());
		for(int i=0; i < keys.size(); i++) {
			stmt.setObject(++count, params.get(keys.get(i)));
		}
		
		if(creation) {
			stmt.setObject(++count, new Date());
		}
		
		if(modification) {
			stmt.setObject(++count, new Date());
		}
		return stmt.executeUpdate();
	}
	
	public int update(Map<String, Object> set, Map<String, Object> where) throws SQLException {
		String sql = String.format(UPDATE, clz.getSimpleName().toLowerCase(),
				this.getSetParams(set),
				this.getWhereParams(where));
		System.out.println(sql);
		Connection conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		int count = 0;
		List<String> keys1 = new ArrayList<>(set.keySet());
		for(int i=0; i < keys1.size(); i++) {
			stmt.setObject(++count, set.get(keys1.get(i)));
		}

		
		List<String> keys2 = new ArrayList<>(where.keySet());
		for(int i=0; i < keys2.size(); i++) {
			stmt.setObject(++count, where.get(keys2.get(i)));
		}

		if(modification) {
			stmt.setObject(++count, new Date());
		}

		return stmt.executeUpdate();
	}
	
	public List<T> getAll() throws SQLException {
		return this.getWhere(null);		
	}
	
	public T findById(Map<String, Object> where) throws SQLException {
		List<T> result = this.getWhere(where);
		if(result.size() == 0) {
			throw new ModelException("There is no result.", false);
		} else if (result.size() > 1) {
			throw new ModelException("Parameter is not ID Columns.", true);
		}
		return result.get(0);
	}
	
	public List<T> getWhere(Map<String, Object> where) throws SQLException {
		String sql = String.format(SELECT, clz.getSimpleName().toLowerCase(),
				this.getWhereParams(where));
		Connection conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);

		if(null != where) {
			List<String> keys2 = new ArrayList<>(where.keySet());
			for(int i=0; i < keys2.size(); i++) {
				stmt.setObject(i + 1, where.get(keys2.get(i)));
			}
		}

		ResultSet res = stmt.executeQuery();
		List<T> list = new ArrayList<>();
		while(res.next()) {
			list.add(this.getObjectFromResult(res));
		}
		return list;		
	}
	
	public int delete(Map<String, Object> where) throws SQLException {
		String sql = String.format(DELETE, clz.getSimpleName().toLowerCase(),
				this.getWhereParams(where));
		Connection conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);

		if(null != where) {
			List<String> keys2 = new ArrayList<>(where.keySet());
			for(int i=0; i < keys2.size(); i++) {
				stmt.setObject(i + 1, where.get(keys2.get(i)));
			}
		}
		
		return stmt.executeUpdate();
	}
	
	protected abstract T getEntity();
	
	private Object getWhereParams(Map<String, Object> where) {
		if(null != where) {
			final StringBuilder sb = new StringBuilder("where ");
			where.keySet().stream().forEach(s -> sb.append(s).append("=? and ,"));
			return sb.substring(0, sb.length() - 5);
		}
		
		return "";
	}

	private Object getSetParams(Map<String, Object> set) {
		final StringBuilder sb = new StringBuilder();
		set.keySet().stream().forEach(s -> sb.append(s).append("=?,"));
		if(modification) {
			sb.append("modification=?");
		}
		return sb.substring(0, sb.length() - 1);
	}

	private String getInsertValues(Map<String, Object> params) {
		final StringBuilder sb = new StringBuilder();
		params.keySet().stream().forEach(s -> sb.append("?").append(","));
		if(creation) {
			sb.append("?,");
		}
		
		if(modification) {
			sb.append("?,");
		}
		return sb.substring(0, sb.length() - 1);
	}

	private String getInsertColumns(Map<String, Object> params) {
		final StringBuilder sb = new StringBuilder();
		params.keySet().stream().forEach(s -> sb.append(s).append(","));
		if(creation) {
			sb.append("creation,");
		}
		
		if(modification) {
			sb.append("modification,");
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	
	private T getObjectFromResult(ResultSet res) {
		T t = null;
		try {
			Field[] fields = this.clz.getDeclaredFields();
			t = getEntity();
			for (Field f : fields) {
				f.setAccessible(true);
				f.set(t, res.getObject(f.getName()));
			}

		} catch (IllegalArgumentException | IllegalAccessException
				| SQLException e) {
			throw new ModelException("Please Check Format of Entity.", true);
		}
		return t;
	}
	
	protected Connection getConnection() throws SQLException {
		if(null == CONN || CONN.isClosed()) {
			CONN = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/se-tutorial", "root", "admin");
		}
		return CONN;
	}
	

}
