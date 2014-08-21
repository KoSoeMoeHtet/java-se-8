package com.jdc.l4.ep3;

public class T4DecisionSwitch {
	
	public static void main(String[] args) {
		switchCase("Rainy");
		switchCase("Fine");
	}
	
	public static void switchCase(String condition) {
		switch (condition) {
		case "Rainy":
		case "Sunny":
			System.out.println("Take umbrella");
			break;
		case "Fine":
			System.out.println("You can go out without umbrella");
			break;
		default:
			System.out.println("Nothing to do");
			break;
		}
	}
}
