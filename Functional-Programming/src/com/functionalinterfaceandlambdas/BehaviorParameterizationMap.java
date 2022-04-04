package com.functionalinterfaceandlambdas;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BehaviorParameterizationMap {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(10, 21, 7, 8, 4, 5);
		
		
		
		
		//Function<? super Integer, ? extends Integer> sqaureMapper = x->x*x;
		
		List<Integer> squareList = mapAndPrint(numbers, x->x*x);
		System.out.println(squareList);
		
		System.out.println(mapAndPrint(numbers, x->x*x*x));

	}

	private static List<Integer> mapAndPrint(List<Integer> numbers, Function<Integer,Integer> mapper) {
		
		return numbers.stream()
						.map(mapper)
						.collect(Collectors.toList());
		
	}

}
