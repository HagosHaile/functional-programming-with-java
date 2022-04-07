package com.customclasses;

import java.util.List;
import java.util.function.Predicate;

public class HigherOrderFunction {

	public static void main(String[] args) {
		//Higher order function is a function which returns a function
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 99, 30000),
				new Course("Spring Boot", "Framework", 92, 15000), 
				new Course("AWS", "Cloud", 98, 20000),
				new Course("Algorithms", "Science", 97, 27000), 
				new Course("Docker", "Cloud", 91, 27000),
				new Course("Microservice", "Framework", 93, 27000), 
				new Course("Kubernetes", "Cloud", 94, 30000)
		);
		
		
		Predicate<Course> reviewScoreGreaterThan95Predicate2 = 
						cutOffReviewPredicate(95);
		
		Predicate<Course> reviewScoreGreaterThan90Predicate2 = 
				cutOffReviewPredicate(90);
			

	}

	//Higher order function
	//passing a function as a parameter, returning a function as a value
	//basically methods are first class citizens as of Java 8
	private static Predicate<Course> cutOffReviewPredicate(int cutOffReview) {
		return course->course.getReviewScore()>cutOffReview;
	}

}
