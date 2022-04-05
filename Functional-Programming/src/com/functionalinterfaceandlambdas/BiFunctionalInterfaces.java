package com.functionalinterfaceandlambdas;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

//BiPredicate, BiFunction, BiConsumer exercises
public class BiFunctionalInterfaces {

	public static void main(String[] args) {
		
		//the output for two inputs is boolean.the reason why boolean is not specified in
		//the type is
		
		BiPredicate<Integer, Integer> biPredicate = (x,y)-> x>y;
		System.out.println(biPredicate.test(4, 6));
		
		
		//has two inputs and one output. returns the specified type.
		BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<>(){
			@Override
			public Integer apply(Integer t, Integer u) {
				return u+t;
			}
		};
		
		System.out.println(biFunction.apply(6, 7));
		
		BiFunction<Integer, Integer, Integer> biFunction2 = (x,y)->x+y;
		
		System.out.println(biFunction2.apply(6, 8));
		
		
		//accepts two inputs and returns nothing
		BiConsumer<Integer, Integer> biConsumer = new BiConsumer<>() {

			@Override
			public void accept(Integer t, Integer u) {
				System.out.println("Sum of the two numbers is "+(t+u));
				
			}
			
		};
		
		biConsumer.accept(11, 7);
		
		BiConsumer<Integer, String> biConsumer2 = (x,y)->{
			System.out.println(x);
			System.out.println(y);
		};
				
				biConsumer2.accept(11, "xyz");
}
}
