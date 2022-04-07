package com.customclasses;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MoreStreamOperatons {

	public static void main(String[] args) {
	
		System.out.println(Stream.of(1,2,3,4,5,6,7)
			.filter(x->x>5)
			.collect(Collectors.toList()));
		
		System.out.println(Stream.of(1,2,3,4,5,6,7)
				.filter(x->x>5)
				.collect(Collectors.toList()));
		
		List<Integer> list = List.of(1,2,3,4,5,6,7);
		//		System.out.println(Arrays.stream(arr)
		//				.filter(x->x>5)
		//				.count());
		Stream<Integer> st = list.stream();
		st.forEach(x->System.out.print(x));
		
		System.out.println("\n==================");
		System.out.println(Stream.of(1,2,3,4,5).reduce(0, Integer::sum));
		
		//stream of promitive int and total
		System.out.println(IntStream.range(1, 10).sum());
		//range doesnt include the last number
		System.out.println(IntStream.range(1, 4).map(x->x*x).sum());
		
		//do some manipulation
		System.out.println(IntStream.iterate(0, e->e+2).limit(3).sum());
		
		//big number factorial of 40
		System.out.println(IntStream.range(1, 40).reduce(1,(x,y)->x*y)); //out of the range of int
		
		//resolve the out of range factorial of 40
		System.out.println(IntStream.range(1, 40).mapToObj(BigInteger::valueOf)
				.reduce(BigInteger.ONE,BigInteger::multiply)); //20397882081197443358640281739902897356800000000
		

	}

}
