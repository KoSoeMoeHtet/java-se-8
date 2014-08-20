package com.jdc.ep1;

public class PrimitiveSample {
	
	public static void main(String[] args) {
		
		System.out.format("Byte Min : %d%n", Byte.MIN_VALUE);
		System.out.format("Byte Max : %d%n", Byte.MAX_VALUE);
		
		System.out.format("Short Min : %d%n", Short.MIN_VALUE);
		System.out.format("Short Max : %d%n", Short.MAX_VALUE);
		
		System.out.format("Integer Min : %d%n", Integer.MIN_VALUE);
		System.out.format("Integer Max : %d%n", Integer.MAX_VALUE);
		
		System.out.format("Long Min : %d%n", Long.MIN_VALUE);
		System.out.format("Long Max : %d%n", Long.MAX_VALUE);
		
		System.out.format("Float Min : %f%n", Float.MIN_VALUE);
		System.out.format("Float Max : %f%n", Float.MAX_VALUE);

		System.out.format("Double Min : %f%n", Double.MIN_VALUE);
		System.out.format("Double Max : %f%n", Double.MAX_VALUE);

		// int with binary
		int decimal = 267;
		int binary = 0b100_001_011;
		int hax = 0x10B;
		int octal = 0413;
		
		System.out.println(decimal);
		System.out.println(binary);
		System.out.println(hax);
		System.out.println(octal);
		
	}

}
