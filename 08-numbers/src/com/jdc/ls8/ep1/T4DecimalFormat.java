package com.jdc.ls8.ep1;

import java.text.DecimalFormat;

public class T4DecimalFormat {
	public static void main(String[] args) {
		System.out.println(new DecimalFormat("###,###.###").format(123456.789));
		System.out.println(new DecimalFormat("###,###.##").format(123456.789));
		System.out.println(new DecimalFormat("000,000.000").format(123456.789));
		System.out
				.println(new DecimalFormat("$###,##0.000").format(123456.789));
	}
}
