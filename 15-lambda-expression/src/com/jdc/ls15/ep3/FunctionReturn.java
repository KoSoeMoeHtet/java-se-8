package com.jdc.ls15.ep3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionReturn {

	public static void main(String[] args) throws IOException {

		Function<String, User> generateUser = a -> {
			Predicate<String> p = b -> b != null && b.split(",").length == 2;
			return p.test(a) ? new User(a.split(",")) : null;
		};

		Function<String, Consumer<User>> userConsumer = generateUser
				.andThen(t -> {
					Consumer<User> c = a -> a.write();
					c.accept(t);
					return c;
				});

		Files.lines(Paths.get("user.txt")).forEach(a -> userConsumer.apply(a));

	}
}
