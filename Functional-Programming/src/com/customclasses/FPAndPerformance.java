package com.customclasses;

import java.util.List;

public class FPAndPerformance {

	public static void main(String[] args) {
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , 
				"Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		//result of parallel Processing
		//this processes until it checks the terminal operator
		//intermediate operations are lazy
		System.out.println(courses.stream().peek(System.out::println)
				.filter(course->course.length()>11)
				.map(String::toUpperCase)
				.peek(System.out::println)); //returns reference nothing else
		
		System.out.println(courses.stream().peek(System.out::println)
				.filter(course->course.length()>11)
				.map(String::toUpperCase)
				.peek(System.out::println)
				.findFirst());
		// ======returns ==========
		//		Spring
		//		Spring Boot
		//		API
		//		Microservices
		//		MICROSERVICES
		//		Optional[MICROSERVICES]
		
		

	}

}
