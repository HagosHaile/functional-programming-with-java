package com.functionalinterfaceandlambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(10, 21, 7, 8, 4, 5);
		
		//Represents a predicate (boolean-valued function) of one argument.
		Predicate<Integer> isEvenpredicate = x->x%2==0;
		
		Predicate<Integer> isEvenpredicate2 = new Predicate<>() {
			
			@Override
			public boolean test(Integer t) {
				return t%2==0;
			}
		};
		
		
		
		Function<Integer, Integer> squareMapper = x->x*x;
		
		Function<Integer, Integer> squareMapper2 = new Function<>() {
			
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
		};
		
		
		Consumer<Integer> printEvenAction = x->System.out.println(x);
		
		Consumer<Integer> printEvenAction2 = new Consumer<>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
		};
		
		numbers.stream()
				.filter(isEvenpredicate)
				.map(squareMapper)
				.forEach(printEvenAction2);

	}

}
