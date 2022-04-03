package com.streamexamples;

import java.util.List;

public class PrintCourses {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		//printAllCourses(courses);
		//printCoursesContainingSpring(courses);
		printCoursesWithMoreThanFourChars(courses);

	}

	//Print All Courses individually
	private static void printAllCourses(List<String> courses) {
		
		courses.stream()
				.forEach(System.out::println);
		
	}
	
	//Print Courses Containing the word "Spring"
	private static void printCoursesContainingSpring(List<String> courses) {
		
		courses.stream()
				.filter(course->course.contains("Spring"))
				.forEach(System.out::println);
		
	}
	
	//Print Courses Whose Name has atleast 4 letters
	private static void printCoursesWithMoreThanFourChars(List<String> courses) {
		
		courses.stream()
				.filter(course->course.length()>=4)
				.forEach(System.out::println);
	}

}
