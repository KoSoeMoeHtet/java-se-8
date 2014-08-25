package com.jdc.shop.model.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.jdc.shop.model.NumberGenerator;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;
import com.jdc.shop.model.Township;

public class RegistrationModelDb implements RegistrationModel{
	
	private NumberGenerator gen;
	private static RegistrationModel model;
	private Properties prop;
	
	public static RegistrationModel getModel() {

		if (null == model) {
			model = new RegistrationModelDb();
		}

		return model;
	}
	
	private RegistrationModelDb() {
		prop = new Properties();
		try {
			prop.load(new FileReader("sql.properties"));
			gen = new NumberGenerator(RegistrationModel.getLastNumber(findAll()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	@Override
	public List<Registration> getRegistrationData(Date from, Date to) {
		
		List<Registration> list = new ArrayList<>();
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(prop.getProperty("select.registration"))) {
			
			stmt.setTimestamp(1, new Timestamp(from.getTime()));
			stmt.setTimestamp(2, new Timestamp(to.getTime()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(getFromResult(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Registration> getSoldData() {
		List<Registration> sellList = new ArrayList<Registration>();
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(prop.getProperty("select.sold"))) {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				sellList.add(getFromResult(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sellList;
	}

	@Override
	public void update(Date from, Date to) {
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(prop.getProperty("select.update"));
				Statement update = conn.createStatement()) {
			
			stmt.setTimestamp(1, new Timestamp(from.getTime()));
			stmt.setTimestamp(2, new Timestamp(to.getTime()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				update.executeUpdate(String.format(prop.getProperty("update"), gen.getNumber(), rs.getInt("id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Registration regist) {

		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(prop.getProperty("insert"))) {
			
			stmt.setString(1, regist.getName());
			stmt.setBoolean(2, regist.isGender());
			stmt.setString(3, regist.getNrc());
			stmt.setDate(4, new java.sql.Date(regist.getBirthDate().getTime()));
			stmt.setInt(5, regist.getTownship().getId());
			stmt.setString(6, regist.getAddress());
			stmt.setTimestamp(7, new Timestamp(regist.getCreation().getTime()));
			stmt.setTimestamp(8, new Timestamp(regist.getModification().getTime()));
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private List<Registration> findAll() {
		List<Registration> list = new ArrayList<>();
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(prop.getProperty("select.all"))) {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(getFromResult(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private Registration getFromResult(ResultSet rs) throws SQLException {
		return new Registration(
				rs.getInt("id"),
				rs.getString("name"), 
				rs.getBoolean("gender"), 
				rs.getString("nrc"), 
				rs.getDate("dob"), 
				rs.getString("address"), 
				new Township(rs.getInt("tid"), rs.getString("tname")), 
				rs.getTimestamp("creation"), 
				rs.getTimestamp("modification"), 
				rs.getString("card"));
	}
	
}
