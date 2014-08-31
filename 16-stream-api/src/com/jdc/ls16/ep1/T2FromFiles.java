package com.jdc.ls16.ep1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class T2FromFiles {

	public static void main(String[] args) throws IOException {
		Files.readAllLines(Paths.get("T2FromFiles.txt")).stream()
				.forEach(System.out::println);
	}

}
