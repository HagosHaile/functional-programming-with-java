package com.filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileManipulation {

	public static void main(String[] args) throws IOException {
		
			Files.lines(Paths.get("file.txt"))
				.forEach(System.out::println);
				
				Files.lines(Paths.get("file.txt"))
					.map(str->str.split(" "))
					.flatMap(Arrays::stream)
					.distinct()
					.sorted()
					.forEach(System.out::println);
		
		//print all directories and files under root
				Files.list(Paths.get("."))
					.forEach(System.out::println);
		
		
		//print list of directories
				Files.list(Paths.get("."))
					.filter(Files::isDirectory)
					.forEach(System.out::println);
		
		//print list of files
				Files.list(Paths.get("."))
					.filter(Files::isRegularFile)
					.forEach(System.out::println);
		
		Files.list(Paths.get("."))
			.filter(t -> {
				try {
					return Files.isHidden(t);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return false;
			})
			.forEach(System.out::println);

	}

}
