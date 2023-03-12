package com.psja.FunctionalInterface;

interface TestAnonymous<T, R>{
	public R getData( T data );
	public T appendData( R data );
}

public class CheckAnonymousClass {

	public static void checkA() {
		TestAnonymous<String, Integer> testAnonymous = new TestAnonymous<String, Integer>() {
			public Integer getData( String data ) {
				return Integer.parseInt( data );
			}
			public String appendData( Integer data ) {
				return data.toString();
			}
		};
		
		System.out.println( testAnonymous.getData( "8" ) );
		System.out.println( testAnonymous.appendData( 4 ) );
	}
	
}
