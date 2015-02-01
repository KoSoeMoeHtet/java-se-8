package com.jdc.ls16.ep2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class T2FromFiles {

	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("T2FromFiles.txt"))
				.forEach(System.out::println);
	}

}
