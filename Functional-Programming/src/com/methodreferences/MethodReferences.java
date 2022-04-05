package com.methodreferences;

import java.util.List;
import java.util.function.Supplier;

public class MethodReferences {

	public static void main(String[] args) {
	
		List<String> courses = List.of("Spring", "Spring Boot", "API" , 
				"Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		//		courses.stream()
		//				.map(str->str.toUpperCase())
		//				.forEach(str->System.out.print(str+", "));
		//		
		//		
		//Method Reference
		//		courses.stream()
		//			.map(str->str.toUpperCase())
		//			.forEach(System.out::println);
		
		courses.stream()
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		//Constructor Reference
		Supplier<String> supplier = String::new;
		System.out.println(supplier.get());

	}

}
