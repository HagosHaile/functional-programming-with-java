package com.streamexamples;

import java.util.List;

public class PlayingWithSreams {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 7, 4, 4, 5);

		int sum = addList(numbers);
		// System.out.println(sum);

		System.out.println(findSumOfOddNumbers(numbers));

	}

	private static int addList(List<Integer> numbers) {

		return numbers.stream().reduce(0, (x, y) -> x + y);

		// return numbers.stream()
		// .reduce(0,Integer::sum); returns the same
	}

	private static int findMaxValue(List<Integer> numbers) {

		return numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);

		// return numbers.stream()
		// .reduce(0,Integer::sum); returns the same
	}

	private static int findMinValue(List<Integer> numbers) {

		return numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x);

	}

	private static int findSumOfSquares(List<Integer> numbers) {

		return numbers.stream().map(x -> x * x).reduce(0, (x, y) -> x + y);

	}

	private static int findSumCubes(List<Integer> numbers) {

		return numbers.stream().map(x -> x * x * x).reduce(0, (x, y) -> x + y);

	}

	private static void printDistinctlist(List<Integer> numbers) {

		numbers.stream().distinct().forEach(System.out::println);
		
		//sorted
		//numbers.stream().sorted().forEach(System.out::println);

	}

	private static int findSumOfOddNumbers(List<Integer> numbers) {

		return numbers.stream().filter(x -> x % 2 == 1).reduce(0, (x, y) -> x + y);

	}

}
