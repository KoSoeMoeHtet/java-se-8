package com.jdc.shop.model.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jdc.shop.model.FileModel;
import com.jdc.shop.model.NumberGenerator;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;

public class RegistrationModelNio implements RegistrationModel, FileModel {

	public static String DATE = "yyyyMMdd HH:mm:ss";

	private static RegistrationModel model;
	private List<Registration> list;
	private NumberGenerator gen;
	
	public static RegistrationModel getModel() {

		if (null == model) {
			model = new RegistrationModelNio();
		}

		return model;
	}

	private RegistrationModelNio() {
		list = new ArrayList<>();
		try {
			List<String> strList = Files.readAllLines(Paths.get(getFileName()));
			list.clear();
			list.addAll(strList.stream()
					.map(a -> getRegistration(a))
					.collect(Collectors.toList()));
		} catch (IOException e) {
			System.err.println("First Time");
		}
		gen = new NumberGenerator(RegistrationModel.getLastNumber(list));
	}

	@Override
	public void save() {
		List<String> stringList = list.stream()
				.map(RegistrationModelNio.this::getLine)
				.collect(Collectors.toList());
		try {
			Files.write(Paths.get(getFileName()), stringList,
					StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFileName() {
		return String.format("%s.txt", Registration.class.getSimpleName());
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
		save();
	}

	@Override
	public void create(Registration regist) {
		list.add(regist);
		save();
	}

}
