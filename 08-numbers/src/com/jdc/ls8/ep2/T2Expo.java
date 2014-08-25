package com.jdc.ls8.ep2;

public class T2Expo {
	public static void main(String[] args) {
		double x = 4;
		double y = 2;

		System.out.printf("The value of " + "e is %.4f%n", Math.E);

		System.out.printf("exp(%.3f) " + "is %.3f%n", x, Math.exp(x));

		System.out.printf("log(%.3f) is " + "%.3f%n", x, Math.log(x));

		System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n", x, y,
				Math.pow(x, y));

		System.out.printf("sqrt(%.3f) is " + "%.3f%n", x, Math.sqrt(x));
	}
}
