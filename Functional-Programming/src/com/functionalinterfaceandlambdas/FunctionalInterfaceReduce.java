package com.functionalinterfaceandlambdas;

import java.util.List;
import java.util.function.BinaryOperator;

public class FunctionalInterfaceReduce {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(10, 21, 7, 8, 4, 5);
		
		BinaryOperator<Integer> totalAccumulator = (x, y) -> x + y;
		
		BinaryOperator<Integer> totalAccumulator2 = new BinaryOperator<>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};
		
		Integer sum = numbers.stream()
				.reduce(0, totalAccumulator2);
		
		Integer sum2 = numbers.stream()
				.reduce(0, Integer::sum);
		
		System.out.println(sum2);

	}

}
