package com.psja.check;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface AdditionCheck{
	public Integer add( Integer a, Integer b );
}

public class InstanceMethodReference {
	
	public Integer checkAdd( Integer a, Integer b ) {
		return a + b;
	}
	
	public void check() {
		InstanceMethodReference instanceMethodReference = new InstanceMethodReference();
		
		Integer tempA = 5;
		Integer tempB = 6;
		
		AdditionCheck a1 = (a, b)-> a + b;
		System.out.println( a1.add( tempA, tempB ) );
		
		AdditionCheck a2 = instanceMethodReference::checkAdd;
		System.out.println( a2.add( tempA, tempB ) );
	}


}
