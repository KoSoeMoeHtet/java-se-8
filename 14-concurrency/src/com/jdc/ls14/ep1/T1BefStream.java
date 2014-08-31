package com.jdc.ls14.ep1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class T1BefStream {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,4,5,6,7,8,9,10);
		int sum = sum(list);
		System.out.println(sum);
	}
	
	static int sum(List<Integer> list) {
		int sum = 0;
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			sum += itr.next(); 
		}
		return sum;
	}

}
