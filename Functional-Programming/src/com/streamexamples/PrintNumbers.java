package com.streamexamples;
import java.util.List;

public class PrintNumbers {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 23, 2, 67, 23,12, 23, 2, 67, 23,100);
		//printAllNumbers(numbers);
		//printEvenNumbers(numbers);
		printOddNumbers(numbers);
	}


	private static void printAllNumbers(List<Integer> numbers) {
	
		System.out.println("Print all numbers ");
		numbers.stream()
			.forEach(System.out::println);
	}
	
	private static void printEvenNumbers(List<Integer> numbers) {
		//add filter
		//use filter(number->number%2==0) which is in lamdba expression instead of
		//filter(PrintNumbers::isEven) which is method reference
		System.out.println("Print only Even numbers ");
		numbers.stream()
			.filter(number->number%2==0) //Lamdba Expression
			.forEach(System.out::println);
	}
	
	//Exercise 1
	private static void printOddNumbers(List<Integer> numbers) {
		numbers.stream()
				.filter(num->num%2==1)
				.forEach(System.out::println);
		
	}

}
