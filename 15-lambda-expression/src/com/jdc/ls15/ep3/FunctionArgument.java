package com.jdc.ls15.ep3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class FunctionArgument {

	public static void main(String[] args) throws IOException {

		Predicate<String> checkString = a -> {
			return a != null && a.split(",").length == 2;
		};

		BiFunction<String, Predicate<String>, User> generateUser = (a, b) -> b
				.test(a) ? new User(a.split(",")) : null;

		Files.lines(Paths.get("user.txt")).forEach(
				s -> generateUser.apply(s, checkString).write());

	}

}
