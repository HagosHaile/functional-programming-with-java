package com.functionalinterfaceandlambdas;

import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SupplierAndUnaryOperator {

	//all these functional interfaces are implemented in 
	//java.util.function package
	public static void main(String[] args) {
		
		// Supplier example
		Supplier<Integer> supplier = ()->{
			Random random = new Random();
			return random.nextInt(1000);
			
		};
		
		System.out.println(supplier.get());
		
		//unary operator example
		UnaryOperator<Integer> unaryOperator = x->5*x;
		System.out.println(unaryOperator.apply(6));
		
		
		

	}

}
