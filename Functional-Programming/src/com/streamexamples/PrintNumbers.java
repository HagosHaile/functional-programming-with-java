package com.streamexamples;

import java.util.List;
import java.util.stream.Collectors;

public class PrintNumbers {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 23, 2, 67, 23, 12, 23, 2, 67, 23, 100);
		// printAllNumbers(numbers);
		// printEvenNumbers(numbers);
		// printOddNumbers(numbers);
		//printSquareOfEvenNumbers(numbers);
		//printCubeOfOddNumbers(numbers);
		
		//List<Integer> doubleList = listOfSquares(numbers);
		//System.out.println(doubleList);
		
		List<Integer> evenList = listOfEven(numbers);
		System.out.println(evenList);
		
	}

	private static void printAllNumbers(List<Integer> numbers) {

		System.out.println("Print all numbers ");
		numbers.stream().forEach(System.out::println);
	}

	private static void printEvenNumbers(List<Integer> numbers) {
		// add filter
		// use filter(number->number%2==0) which is in lamdba expression instead of
		// filter(PrintNumbers::isEven) which is method reference
		System.out.println("Print only Even numbers ");
		numbers.stream().filter(number -> number % 2 == 0) // Lamdba Expression
				.forEach(System.out::println);
	}

	
	private static void printOddNumbers(List<Integer> numbers) {
		numbers.stream()
				.filter(num -> num % 2 == 1)
				.forEach(System.out::println);

	}

	private static void printSquareOfEvenNumbers(List<Integer> numbers) {

		System.out.println("Print square of only Even numbers ");
		numbers.stream()
				.filter(number -> number % 2 == 0) // Lamdba Expression
				.map(num -> num * num)
				.forEach(System.out::println);
	}

	private static void printCubeOfOddNumbers(List<Integer> numbers) {

		System.out.println("Print cube of only Odd numbers ");
		numbers.stream()
				.filter(number -> number % 2 == 0) // Lamdba Expression
				.map(num -> num * num * num)
				.forEach(System.out::println);
	}
	
	private static List<Integer> listOfSquares(List<Integer> numbers) {

		System.out.println("List of square of numbers");
		return numbers.stream()
				.map(num -> num * num)
				.collect(Collectors.toList());
	}
	
	private static List<Integer> listOfEven(List<Integer> numbers) {

		System.out.println("List of square of numbers");
		return numbers.stream()
				.filter(num -> num %2==0)
				.collect(Collectors.toList());
	}

}
