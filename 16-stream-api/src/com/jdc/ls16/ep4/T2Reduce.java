package com.jdc.ls16.ep4;

import java.util.stream.Stream;

import com.jdc.ls16.ep3.T0Common;
import com.jdc.ls16.ep3.T0Common.User;

public class T2Reduce {
	
	public static void main(String[] args) {
		Stream<User> stream = T0Common.getUser().stream();
		int sum = stream.map(a -> a.getAge())
				.reduce(0, (a, b) -> {
					System.out.println("a -> " + a);	
					System.out.println("b -> " + b);	
					return a + b; });
		System.out.println(sum);
	}

}
