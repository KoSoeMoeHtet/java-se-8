package com.jdc.shop.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.jdc.shop.ShopAppException;

public interface FileModel {
	void save();
	String getFileName();

	public static String DATE = "yyyyMMdd HH:mm:ss";

	
	public default Registration getRegistration(String line) {

		Registration r = null;

		try {
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
		} catch (ParseException e) {
			throw new ShopAppException(e.getMessage());
		}
		
		return r;

	}

	public default String getLine(Registration r) {
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

}
