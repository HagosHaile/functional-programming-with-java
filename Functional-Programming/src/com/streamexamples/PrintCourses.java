package com.streamexamples;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintCourses {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		//printAllCourses(courses);
		//printCoursesContainingSpring(courses);
		//printCoursesWithMoreThanFourChars(courses);
		//printCoursesInOrderOfLength(courses);
		List<String> coursesLength = printLengthOfCoursesList(courses);
		System.out.println(coursesLength);

	}

	//Print All Courses individually
	private static void printAllCourses(List<String> courses) {
		System.out.println("Print All Courses individually");
		courses.stream()
				.forEach(System.out::println);
		
	}
	
	//Print Courses Containing the word "Spring"
	private static void printCoursesContainingSpring(List<String> courses) {
		System.out.println("Print Courses Containing the word \"Spring\"");
		courses.stream()
				.filter(course->course.contains("Spring"))
				.forEach(System.out::println);
		
	}
	
	//Print Courses Whose Name has at least 4 letters
	private static void printCoursesWithMoreThanFourChars(List<String> courses) {
		System.out.println("Print Courses Whose Name has atleast 4 letters");
		courses.stream()
				.filter(course->course.length()>=4)
				.forEach(System.out::println);
	}
	
	private static void printLengthOfCourses(List<String> courses) {
		System.out.println("Print Length of Courses");
		courses.stream()
				.map(course->course + ": "+course.length())
				.forEach(System.out::println);
	}
	
	private static void printCoursesInOrder(List<String> courses) {
		System.out.println("Courses printed in alphabetical order");
		courses.stream()
				.sorted()
				.forEach(System.out::println);
	}
	
	private static void printCoursesInOrderOfLength(List<String> courses) {
		System.out.println("Courses printed in the order of thier length");
		courses.stream()
				.sorted(Comparator.comparing(str->str.length()))
				.forEach(System.out::println);
	}
	
	private static List<String> printLengthOfCoursesList(List<String> courses) {
		System.out.println("Print Length of Courses");
		return courses.stream()
				.map(course->course + ": "+course.length())
				.collect(Collectors.toList());
	}


}
