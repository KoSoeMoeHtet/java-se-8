package com.jdc.shop.data;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationData {

	private static List<RegistDto> registList;
	private static DateFormat df = new SimpleDateFormat("yyyyMMdd");
	
	static {
		registList = new ArrayList<>();
	}
	
	public static void addData(RegistDto dto) {
		registList.add(dto);
	}
	
	public static List<RegistDto> getRegistrationData() {
		return registList.stream().filter(e -> e.getCardNum().equals("NO_CARD")).collect(Collectors.toList());
	}
	
	public static List<RegistDto> getRegistrationData(int count) {
		return registList.stream().filter(e -> e.getCardNum().equals("NO_CARD")).limit(count).collect(Collectors.toList());
	}
	
	public static void addSellData(RegistDto dto) {
		for(RegistDto d : registList) {
			if(d.sameRegistration(dto)) {
				d.setCardNum(dto.getCardNum());
			}
		}
	}
	
	public static List<RegistDto> getSellData() {
		return registList.stream().filter(e -> !e.getCardNum().equals("NO_CARD")).collect(Collectors.toList());
	}

	public static String getLastCardNumber() {
		List<RegistDto> list = getSellData();
		if(list.size() > 0) {
			return list.get(list.size() - 1).getCardNum();
		}
		return null;
	}
	
	public static String nextCardNumber(String lastNumber) throws ParseException {
		Date date = null;
		int serialNum = 0;
		if (lastNumber != null) {
			String strDate = lastNumber.substring(0, 8);
			String strNum = lastNumber.replace(strDate, "");

			serialNum = Integer.parseInt(strNum);
			date = new SimpleDateFormat("yyyyMMdd").parse(strDate);
		}

		if(null != date && isToday(date)) {
			serialNum ++;
		} else {
			serialNum = 1;
		}

		return String.format("%s%s", df.format(new Date()), new DecimalFormat("0000").format(serialNum));
	}
	
	private static boolean isToday(Date date) {
		return df.format(date).equals(df.format(new Date()));
	}
	
	
}
