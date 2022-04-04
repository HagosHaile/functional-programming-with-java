package com.functionalinterfaceandlambdas;

import java.util.List;
import java.util.function.Predicate;

public class BehaviorParameterization {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(10, 21, 7, 8, 4, 5);
		
		
		
		//Predicate<? super Integer> evenPredicate = x->x%2==0;
		System.out.println("Print Even Numbers");
		filterAndPrint(numbers, x->x%2==0);
		System.out.println("Print Odd Numbers");
		filterAndPrint(numbers, x->x%2!=0);
		System.out.println("Print Multiples of 3");
		filterAndPrint(numbers, x->x%3==0);
		

	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
		
	}

}
