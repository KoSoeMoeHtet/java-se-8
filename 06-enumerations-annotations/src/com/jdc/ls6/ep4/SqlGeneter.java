package com.jdc.ls6.ep4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.control.Tab;

public class SqlGeneter {
	
	
	static String getSelectSql(Student s) {
		String table = getTableName(s);
		
		List<String> colomns = Arrays.asList(s.getClass().getDeclaredFields()).stream()
			.map(a -> a.getName())
			.collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		for(int i = 0; i < colomns.size(); i++) {
			if(i > 0) {
				sb.append(", ");
			}
			
			sb.append(colomns.get(i));
		}
		
		sb.append(" from ");
		sb.append(table);
		
		return sb.toString();
	}
	
	private static String getTableName(Student s) {
		Table t = s.getClass().getDeclaredAnnotation(Table.class);
		if(null == t) {
			return s.getClass().getSimpleName().toLowerCase();
		} else {
			return t.value();
		}
	}

	public static void main(String[] args) {
		Student student = new Student();
		System.out.println(getSelectSql(student));
	}

}
