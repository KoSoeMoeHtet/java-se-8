package com.jdc.ls1.ep4;

public class Overload {

    void multiply(int a, int b, int c) {
        System.out.println(a + " * " + b +
			 " * " + c + " is " + (a * b * c));
    }
    
    void multiply(int a, int b) {
        System.out.println("default value for c is 1");
        multiply(a, b, 1);
    }
    
    public static void main(String[] args) {
        Overload o = new Overload();
        o.multiply(2, 3, 4);
        o.multiply(2, 3);
    }
}
