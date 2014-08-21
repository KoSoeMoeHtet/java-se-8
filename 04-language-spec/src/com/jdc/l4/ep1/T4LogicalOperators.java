package com.jdc.l4.ep1;

public class T4LogicalOperators {

	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean c = true;
		boolean d = false;

		String format = "%s %s %s = %s%n";

		// && Logical AND
		System.out.format(format, a, "&&", b, (a && b));
		System.out.format(format, a, "&&", c, (a && c));
		System.out.format(format, b, "&&", c, (b && c));
		System.out.format(format, b, "&&", d, (b && d));

		// & boolean Logical AND
		System.out.format(format, a, "&", b, (a & b));
		System.out.format(format, a, "&", c, (a & c));
		System.out.format(format, b, "&", c, (b & c));
		System.out.format(format, b, "&", d, (b & d));
		
		// || Logical OR
		System.out.format(format, a, "||", b, (a || b));
		System.out.format(format, a, "||", c, (a || c));
		System.out.format(format, b, "||", c, (b || c));
		System.out.format(format, b, "||", d, (b || d));
		
		// | boolean Logical OR 
		System.out.format(format, a, "|", b, (a | b));
		System.out.format(format, a, "|", c, (a | c));
		System.out.format(format, b, "|", c, (b | c));
		System.out.format(format, b, "|", d, (b | d));
		
		
		// ! Logical NOT
		System.out.format("!%s = %s%n", a, (!a));
		System.out.format("!%s = %s%n", b, (!b));
		
		// ^ boolean logical exclusive
		System.out.format(format, a, "^", b, (a ^ b));
		System.out.format(format, a, "^", c, (a ^ c));
		System.out.format(format, b, "^", c, (b ^ c));
		System.out.format(format, b, "^", d, (b ^ d));
	}

}
