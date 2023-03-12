package com.psja.check;

import java.util.Arrays;
import java.util.List;
import java.lang.FunctionalInterface;

@FunctionalInterface
interface function{
	public void add( List<Integer> num );
}

public class TestAll {

	public void addAll(List<Integer> num) {
		Integer sum = 0;
		for ( Integer t:num ) 
			sum = sum + t;
		System.out.println( sum );
	}
	
	public void see() {
		
		List<Integer> numList = Arrays.asList( 1, 2, 3, 4, 5 );
		
		function fun1 = new function(){
			public void add( List<Integer> num ) {
				Integer sum = 0;
				for ( Integer t:num ) 
					sum = sum + t;
				System.out.println( sum );
			}
		};
		fun1.add(numList);
		
		TestAll test = new TestAll();
		function fun2 = test::addAll;
		fun2.add(numList);
		
		function fun3 = ( num )->{
			Integer sum = 0;
			for ( Integer t:num ) 
				sum = sum + t;
			System.out.println( sum );
		};
		fun3.add(numList);
		
	}
}
