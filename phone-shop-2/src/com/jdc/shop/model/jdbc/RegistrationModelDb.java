package com.jdc.shop.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdc.shop.model.NumberGenerator;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;
import com.jdc.shop.model.Township;

public class RegistrationModelDb implements RegistrationModel{
	
	private NumberGenerator gen;
	private static RegistrationModel model;
	public static RegistrationModel getModel() {

		if (null == model) {
			model = new RegistrationModelDb();
		}

		return model;
	}
	
	private RegistrationModelDb() {
		gen = new NumberGenerator(RegistrationModel.getLastNumber(findAll()));
	} 

	@Override
	public List<Registration> getRegistrationData(Date from, Date to) {
		
		List<Registration> list = new ArrayList<>();
		String select = "select r.id id, r.name name, r.gender gender,"+
				"r.nrc nrc, r.dob dob, t.id tid, t.name tname, r.address address," +
				"r.creation creation, r.modification modification, r.card card" +
				" from registration r "+
				"left join township t on t.id = r.township_id "+
				"where isnull(r.card) and r.creation >= ? and r.creation < ?" ;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(select)) {
			
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
		String select = "select r.id id, r.name name, r.gender gender,"+
				"r.nrc nrc, r.dob dob, t.id tid, t.name tname, r.address address," +
				"r.creation creation, r.modification modification, r.card card" +
				" from registration r "+
				"left join township t on t.id = r.township_id "+
				"where r.card <> '' order by r.card desc" ;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(select)) {
			
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
		String select = "select * from registration r "+
				"where isnull(r.card) and r.creation >= ? and r.creation < ?" ;
		String updSQL = "update registration set card = %s where id = %d";
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(select);
				Statement update = conn.createStatement()) {
			
			stmt.setTimestamp(1, new Timestamp(from.getTime()));
			stmt.setTimestamp(2, new Timestamp(to.getTime()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				update.executeUpdate(String.format(updSQL, gen.getNumber(), rs.getInt("id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Registration regist) {
		String sql = "insert into registration (name, gender, nrc, dob, township_id, address, creation, modification)" +
				" values (?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
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
		String select = "select r.id id, r.name name, r.gender gender,"+
				"r.nrc nrc, r.dob dob, t.id tid, t.name tname, r.address address, " +
				"r.creation creation, r.modification modification, r.card card" +
				" from registration r "+
				"left join township t on t.id = r.township_id" ;
		
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(select)) {
			
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
