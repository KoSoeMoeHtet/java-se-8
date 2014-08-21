package com.jdc.l4.ep3;

public class T3DecisionIfElseIfElse {
	
	public static void main(String[] args) {
		showGrade(39);
		showGrade(40);
		showGrade(79);
		showGrade(80);
	}
	
	public static void showGrade(int mark) {
		if(mark < 40)
			System.out.println("Fail");
		else if (mark >= 40 && mark < 80)
			System.out.println("Normal Pass");
		else
			System.out.println("Execelent");
	}

}
