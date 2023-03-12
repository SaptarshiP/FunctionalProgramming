package com.psja;

import static java.lang.System.out;

import com.psja.stream.CheckFilterStream;

public class CheckStreamAPI {

	public static void main( String args[] ) {
		out.println( "Check Stream API" );
		CheckFilterStream checkFilterStream = new CheckFilterStream();
		checkFilterStream.checkFil();
	}
}
