package com.jdc.shop.model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdc.shop.model.FileModel;
import com.jdc.shop.model.NumberGenerator;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;

public class RegistrationModelBuf implements RegistrationModel, FileModel {

	private static RegistrationModel model;
	private List<Registration> list;
	private NumberGenerator gen;
	
	public static RegistrationModel getModel() {

		if (null == model) {
			model = new RegistrationModelBuf();
		}

		return model;
	}

	private RegistrationModelBuf() {
		list = new ArrayList<Registration>();

		try (BufferedReader br = new BufferedReader(new FileReader(getFileName()))) {
			String line = null;

			while ((line = br.readLine()) != null) {
				list.add(getRegistration(line));
			}

		} catch (IOException e) {
			if (e instanceof IOException)
				System.out
						.println("Registration file not found in initial state.");
			else
				System.out.println("System Error");
		}
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
		this.save();
	}

	@Override
	public void create(Registration regist) {
		list.add(regist);
		this.save();
	}

	@Override
	public void save() {
		try (PrintWriter pw = new PrintWriter(getFileName())) {
			for (Registration r : list) {
				pw.println(getLine(r));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFileName() {
		return String.format("%s.txt", Registration.class.getSimpleName());
	}

}
