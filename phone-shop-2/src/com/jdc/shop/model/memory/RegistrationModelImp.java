package com.jdc.shop.model.memory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdc.shop.model.NumberGenerator;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;

public class RegistrationModelImp implements RegistrationModel {
	private static RegistrationModel model;
	private List<Registration> list;
	private NumberGenerator gen;

	public static RegistrationModel getModel() {

		if (null == model) {
			model = new RegistrationModelImp();
		}

		return model;
	}

	private RegistrationModelImp() {
		list = new ArrayList<Registration>();
		gen = new NumberGenerator(RegistrationModel.getLastNumber(list));
	}

	@Override
	public List<Registration> getRegistrationData(Date from, Date to) {
		return RegistrationModel.getRegistrationData(from, to, list);
	}

	@Override
	public List<Registration> getSoldData() {
		return RegistrationModel.getSoldData(list);
	}

	@Override
	public void update(Date from, Date to) {
		RegistrationModel.update(from, to, list, gen);
	}

	@Override
	public void create(Registration regist) {
		list.add(regist);
	}
}
