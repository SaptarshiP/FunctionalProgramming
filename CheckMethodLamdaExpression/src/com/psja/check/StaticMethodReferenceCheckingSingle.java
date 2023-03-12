package com.psja.check;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface GetNumber{
	public Boolean testNumber( Integer i );
}

public class StaticMethodReferenceCheckingSingle {

	public static Boolean checkNumber( Integer i ) {
		return i>=1 && i<10;
	}
	
	public void check() {
		
		Integer temp = 12;
		GetNumber gN = ( r )-> r>=1 && r<10;
		System.out.println( gN.testNumber( temp ) );
		
		GetNumber gN1 = StaticMethodReferenceCheckingSingle::checkNumber;
		System.out.println( gN1.testNumber( temp ) );
	}
}
