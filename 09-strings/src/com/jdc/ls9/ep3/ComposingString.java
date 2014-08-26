package com.jdc.ls9.ep3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComposingString {
	
	static String SELECT = "select * from";
	static String TABLE = "USER";
	static String WHERE = "where";
	static String SPACE = " ";
	static String EQ = "=";
	static String AND = "AND";
	
	public static String getSQL(Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		sb.append(SELECT).append(SPACE);
		sb.append(TABLE).append(SPACE);
		
		if(!param.isEmpty()) {
			sb.append(WHERE).append(SPACE);
			List<String> keys = new ArrayList<String>(param.keySet());
			for(int i =0; i < keys.size(); i ++) {
				sb.append(keys.get(i)).append(SPACE)
					.append(EQ).append(SPACE)
					.append("'").append(param.get(keys.get(i))).append("'")
					.append(SPACE);
				
				if(i < keys.size() - 1) {
					sb.append(AND).append(SPACE);
				}
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "10");
		
		System.out.println(getSQL(map));
		
		map.put("name", "Mg Mg");
		System.out.println(getSQL(map));
	}
}
