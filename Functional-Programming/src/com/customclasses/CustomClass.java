package com.customclasses;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomClass {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 99, 30000),
				new Course("Spring Boot", "Framework", 92, 15000), 
				new Course("AWS", "Cloud", 98, 20000),
				new Course("Algorithms", "Science", 97, 27000), 
				new Course("Docker", "Cloud", 91, 27000),
				new Course("Microservice", "Framework", 93, 27000), 
				new Course("Kubernetes", "Cloud", 94, 30000)
		);
		
		
		Predicate<Course> reviewScoreGreaterThan95Predicate = 
						course->course.getReviewScore()>95;
		
		Predicate<Course> reviewScoreGreaterThan90Predicate = 
						course->course.getReviewScore()>90;
						
		Predicate<Course> reviewScoreGreaterThan100Predicate = 
						course->course.getReviewScore()>100;
		
		// allMatch
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));
		if (courses.stream().allMatch(reviewScoreGreaterThan90Predicate)) {
			System.out.println("all reviews are above 90");
		}

		// allMatch
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

		// anyMatch
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan100Predicate));

		// noneMatch
		System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan100Predicate));
		
						
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);

		List<Course> list = courses.stream().sorted(comparingByNoOfStudentsIncreasing)
				.collect(Collectors.toList());

		System.out.println(list);
		
		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();

		List<Course> list2 = 
				courses.stream()
					.sorted(comparingByNoOfStudentsDecreasing)
					.collect(Collectors.toList());
		System.out.println(list2);
		
		
		Comparator<Course> comparingByNoOfStudentsAndReview = 
				Comparator.comparing(Course::getNoOfStudents)
							.thenComparing(Course::getReviewScore)
							.reversed();
		//print in decreasing order by no of students and then by review
		List<Course> list3 = 
				courses.stream()
					.sorted(comparingByNoOfStudentsAndReview)
					.collect(Collectors.toList());
		System.out.println(list3);
		
		//print in top 3
		List<Course> list4 = 
				courses.stream()
					.sorted(comparingByNoOfStudentsAndReview)
					.limit(3)
					.collect(Collectors.toList());
		System.out.println(list4);
		
		////print by skipping top 3
		List<Course> list5 = 
				courses.stream()
					.sorted(comparingByNoOfStudentsAndReview)
					.skip(3)
					.collect(Collectors.toList());
		System.out.println(list5);
		
		//skip three and print 2
		List<Course> list6 = 
				courses.stream()
					.sorted(comparingByNoOfStudentsAndReview)
					.skip(3)
					.limit(2)
					.collect(Collectors.toList());
		System.out.println(list6);
		
		//Print the 5th one
		List<Course> list7 = 
				courses.stream()
					.sorted(comparingByNoOfStudentsAndReview)
					.skip(4)
					.limit(1)
					.collect(Collectors.toList());
		System.out.println(list7);
		
		//print all courses
		System.out.println(courses);
		
		//print all courses until you get review less than 95
		List<Course> listUntilReviewLessThan95 =
		courses.stream()
				.takeWhile(course->course.getReviewScore()>=95)
				.collect(Collectors.toList());
		
		System.out.println(listUntilReviewLessThan95);
		
		//drop while
		List<Course> listUntilReviewGreaterThan95 =
				courses.stream()
						.dropWhile(course->course.getReviewScore()>=95)
						.collect(Collectors.toList());
				
				System.out.println(listUntilReviewGreaterThan95);
			
				
		System.out.println(courses.stream()
							.sorted(comparingByNoOfStudentsAndReview).collect(Collectors.toList()));
		//max returns the last value
		Optional<Course> listLast =
						courses.stream()
							.max(comparingByNoOfStudentsAndReview);
		System.out.println(listLast);
		
		Optional<Course> listFirst =
				courses.stream()
					.min(comparingByNoOfStudentsAndReview);

		System.out.println(listFirst);//reviewScoreGreaterThan100Predicate
		
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan100Predicate)
					.min(comparingByNoOfStudentsAndReview)
					.orElse(new Course("Java", "Coding", 50000, 21123)));
		
		//sum, average, and count
		//grouping using map and groupingBy
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getReviewScore)
				.sum());
		
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getReviewScore)
				.average());
		
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.count());
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory)));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
	}

}

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ": " + noOfStudents + ": " + reviewScore;
	}

}
