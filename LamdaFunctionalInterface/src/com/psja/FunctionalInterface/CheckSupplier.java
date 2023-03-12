package com.psja.FunctionalInterface;

import java.util.function.Supplier;

public class CheckSupplier {

	public String checkMethodReferenceWithSupplier() {
		return "In the method reference";
	}
	
	public void checkSuppl() {
		String product = "PSJA";
		Supplier<Integer> s1 = ()-> 10/2;
		Supplier<Boolean> s2 = ()->product.length() == 5;
		Supplier<Integer> s3 = ()->product.length() - 1;
		Supplier<String> s4 = new Supplier<String>(){
								public String get() {
									return product.toUpperCase()+" in anonymous class";
								}
							};
		Supplier<String> s5 = ()->{
								System.out.println( "Here" );
								return product.toLowerCase();
							};
		CheckSupplier chSupplr = new CheckSupplier();
		Supplier<String> s6 = chSupplr::checkMethodReferenceWithSupplier;
		System.out.println( s1.get() );
		System.out.println( s2.get() );
		System.out.println( s3.get() );
		System.out.println( s4.get() );
		System.out.println( s5.get() );
		System.out.println( s6.get() );
	}
}
