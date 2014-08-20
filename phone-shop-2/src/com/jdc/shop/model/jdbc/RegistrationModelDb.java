package com.jdc.shop.model.jdbc;

import java.util.Date;
import java.util.List;

import com.jdc.shop.model.FileModel;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;

public class RegistrationModelDb implements RegistrationModel, FileModel {

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Registration> getRegistrationData(Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Registration> getSoldData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Date from, Date to) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(Registration regist) {
		// TODO Auto-generated method stub

	}

}
