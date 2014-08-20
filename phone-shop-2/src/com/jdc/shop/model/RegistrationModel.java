package com.jdc.shop.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface RegistrationModel {

	public List<Registration> getRegistrationData(Date from, Date to);
	public List<Registration> getSoldData();
	public void update(Date from, Date to);
	public void create(Registration regist);
	
	public static List<Registration> getRegistrationData(Date from, Date to, List<Registration> list) {
		return list.stream().filter(e -> e.getCardNumber() == null)
				.filter(e -> e.getCreation().compareTo(from) >= 0)
				.filter(e -> e.getCreation().compareTo(to) <= 0)
				.collect(Collectors.toList());
	}
	
	public static List<Registration> getSoldData(List<Registration> list) {
		return list.stream().filter(t -> t.getCardNumber() != null)
				.collect(Collectors.toList());
	}
	
	public static void update(Date from, Date to, List<Registration> list, NumberGenerator gen) {
		list.stream().filter(e -> e.getCardNumber() == null)
			.filter(e -> e.getCreation().compareTo(from) >= 0)
			.filter(e -> e.getCreation().compareTo(to) <= 0)
			.forEach(e -> e.setCardNumber(gen.getNumber()));
	}
	
	public static Optional<String> getLastNumber(List<Registration> list) {
		return list.stream().filter(a -> a.getCardNumber() != null)
				.map(a -> a.getCardNumber()).sorted((a, b) -> b.compareTo(a))
				.findFirst();
	}

}
