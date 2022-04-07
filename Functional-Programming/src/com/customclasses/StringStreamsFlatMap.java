package com.customclasses;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreamsFlatMap {

	public static void main(String[] args) {
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , 
				"Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		//list of all course chars
		
		
		System.out.println(courses.stream().map(s->s.split("")).flatMap(Arrays::stream)
		.collect(Collectors.toList()));
		
		//distinct chars
		System.out.println(courses.stream().map(s->s.split("")).flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList()));
		
		//tuples of courses
		List<String> courses2 = List.of("Spring", "Spring Boot", "API" , 
				"Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

		courses.stream().flatMap(course1->courses2.stream().map(course2->
		List.of(course1,course2))).collect(Collectors.toList());
		
		System.out.println(courses.stream().flatMap(course1->courses2.stream().map(course2->
		List.of(course1,course2))).collect(Collectors.toList()));
		
		//Remove a list of the same strings like Spring and Spring
		System.out.println(courses.stream().flatMap(course1->courses2.stream()
				.map(course2->
		List.of(course1,course2)))
				.filter(list->!list.get(0).equals(list.get(1)))
				.collect(Collectors.toList()));
		
		//list the courses with different length
		System.out.println(courses.stream().flatMap(course1->courses2.stream()
				.filter(course2->course2.length()==course1.length())
				.map(course2->
		List.of(course1,course2)))
				.filter(list->!list.get(0).equals(list.get(1)))
				.collect(Collectors.toList()));
		
	}

}
