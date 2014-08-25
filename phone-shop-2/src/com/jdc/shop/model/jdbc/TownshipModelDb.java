package com.jdc.shop.model.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.shop.model.Township;
import com.jdc.shop.model.TownshipModel;
import com.jdc.shop.model.io.TownshipModelObj;

public class TownshipModelDb implements TownshipModel {
	
	private static TownshipModel model;

	public static TownshipModel getModel() {
		if (null == model)
			model = new TownshipModelDb();
		return model;
	}

	private List<Township> townships;
	
	private TownshipModelDb() {
		loadData();
	}
	
	private void loadData() {
		townships = new ArrayList<Township>();
		String sql = "select * from township order by id";
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()) {
				Township t = new Township(res.getInt("id"), res.getString("name"));
				townships.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Township> getTownships() {
		return this.townships;
	}

	public void addToDb(List<Township> list) {
		try (Connection conn = ConnectionManager.getConnection();
				Statement stmt = conn.createStatement()) {
			for(Township t : list) {
				stmt.addBatch(getInsertSQL(t));
			}
			
			stmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		loadData();
	}
	
	private String getInsertSQL(Township ts) {
		String insert = "insert into township(name) values ('%s')";
		return String.format(insert, ts.getName());
	}
	
	public static void main(String[] args) {
		TownshipModel tm1 = TownshipModelObj.getModel();
		TownshipModelDb tm2 = new TownshipModelDb();
		
		tm2.addToDb(tm1.getTownships());
	}

}
