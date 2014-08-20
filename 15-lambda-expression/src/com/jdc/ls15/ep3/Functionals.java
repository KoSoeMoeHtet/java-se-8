package com.jdc.ls15.ep3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

public class Functionals {

	public static void main(String[] args) throws IOException {

		Function<String, User> converter = a -> {
			String[] str = a.split(",");
			if (str.length == 2) {
				return new User(str[0], str[1]);
			}

			return null;
		};

		Files.readAllLines(Paths.get("user.txt")).forEach(
				a -> converter.apply(a).write());
	}

}
