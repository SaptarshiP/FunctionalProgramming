package com.psja.check;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface A{
	public void showOutput();
}

public class StaticMethodReference {

	public static void showInfo() {
		System.out.println( "Here in the showInfo" );
	}
	
	public void check() {
		A a1 = ()->System.out.println( "In lamda expression" );
		a1.showOutput();
		
		A a2 = StaticMethodReference::showInfo; //ClassMethodName::static_method_name
		a2.showOutput();
	}
}
