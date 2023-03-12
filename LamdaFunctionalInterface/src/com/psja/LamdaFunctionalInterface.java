package com.psja;

import static java.lang.System.out;

import com.psja.FunctionalInterface.CheckAnonymousClass;
import com.psja.FunctionalInterface.CheckConsumer;
import com.psja.FunctionalInterface.CheckFunction;
import com.psja.FunctionalInterface.CheckPredicate;
import com.psja.FunctionalInterface.CheckSupplier;

public class LamdaFunctionalInterface {

	public static void main( String args[] ) {
		out.println( "In the lamda functional Interface" );
		
		out.println( "*******Check Supplier*******" );
		//CheckSupplier chSupplier = new CheckSupplier();
		//chSupplier.checkSuppl();
		
		out.println( "*******Check Consumer*******" );
		//CheckConsumer checkConsumer = new CheckConsumer();
		//checkConsumer.checkCon();
		out.println("********Check Predicate******" );
		//CheckPredicate checkPredicate = new CheckPredicate();
		//checkPredicate.chpl();
		out.println( "********Check Function**********" );
		CheckFunction chF = new CheckFunction();
		chF.chFun();
		//CheckAnonymousClass.checkA();
	}
	
}
