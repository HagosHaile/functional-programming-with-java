package com.customclasses;

import java.util.stream.LongStream;

public class FPParallel {

	public static void main(String[] args) {
		
		//make use of all your processors
		//lets take huge set of numbers
		System.out.println("Run this in in sequence");
		long time = System.currentTimeMillis();
		System.out.println(LongStream.range(0, 1000000000).sum()); 
		//sum is 499999999500000000
		//time taken is 368ms
		System.out.println(System.currentTimeMillis()-time);//
		
		//Run this in Parallel
		System.out.println("Run this in Parallel");
		long time2 = System.currentTimeMillis();
		System.out.println(LongStream.range(0, 1000000000)
				.parallel()
				.sum()); 
		//sum is 499999999500000000
		//time taken is 61ms
		//here java splits the streams in multiple pads
		System.out.println(System.currentTimeMillis()-time2);//

	}

}
