package com.jdc.shop.model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdc.shop.model.FileModel;
import com.jdc.shop.model.NumberGenerator;
import com.jdc.shop.model.Registration;
import com.jdc.shop.model.RegistrationModel;
import com.jdc.shop.model.Township;

public class RegistrationModelBuf implements RegistrationModel, FileModel {

	public static String DATE = "yyyyMMdd HH:mm:ss";

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

		} catch (IOException | ParseException e) {
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

	private Registration getRegistration(String line)
			throws ParseException {

		Registration r = null;
		String[] str = line.split("\t");
		DateFormat df = new SimpleDateFormat(DATE);

		if (str.length == 10) {
			r = new Registration();
			r.setName(str[0]);
			r.setGender(Boolean.valueOf(str[1]));
			r.setNrc(str[2]);
			r.setBirthDate(df.parse(str[3]));
			r.setAddress(str[4]);

			if (!str[5].isEmpty())
				r.setTownship(new Township(Integer.parseInt(str[5]), str[6]));

			r.setCreation(df.parse(str[7]));
			r.setModification(df.parse(str[8]));

			if (!"null".equals(str[9]))
				r.setCardNumber(str[9]);
		}
		
		return r;

	}

	public String getLine(Registration r) {
		DateFormat df = new SimpleDateFormat(DATE);
		StringBuilder sb = new StringBuilder();
		sb.append(r.getName()).append("\t");
		sb.append(r.isGender()).append("\t");
		sb.append(r.getNrc()).append("\t");
		sb.append(df.format(r.getBirthDate())).append("\t");
		sb.append(r.getAddress()).append("\t");
		Township township = r.getTownship();
		if (null != township) {
			sb.append(township.getId()).append("\t");
			sb.append(township.getName()).append("\t");
		} else {
			sb.append("").append("\t");
			sb.append("").append("\t");
		}
		sb.append(df.format(r.getCreation())).append("\t");
		sb.append(df.format(r.getModification())).append("\t");
		sb.append(r.getCardNumber());

		return sb.toString();
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
