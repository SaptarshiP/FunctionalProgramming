package com.psja;

import static java.lang.System.out;

import com.psja.check.ConstructorReference;
import com.psja.check.ConstructorReferenceWithParameter;
import com.psja.check.InstanceMethodReference;
import com.psja.check.StaticMethodReference;
import com.psja.check.StaticMethodReferenceCheckingSingle;
import com.psja.check.TestAll;

public class CheckMethodLamdaExpression {

	public static void main( String args[] ) {
		out.println( "In the main class" );
		StaticMethodReference staticMethodReference = new StaticMethodReference();
		staticMethodReference.check();
		
		System.out.println( "***Checking Number*********" );
		StaticMethodReferenceCheckingSingle staticMethodReferenceCheckingSingle = new StaticMethodReferenceCheckingSingle();
		staticMethodReferenceCheckingSingle.check();
		
		System.out.println( "*******Checking Method reference for instance method********" );
		InstanceMethodReference instanceMethodReference = new InstanceMethodReference();
		instanceMethodReference.check();
		
		System.out.println( "******Checking Method reference for Constructor reference*******" );
		ConstructorReference constructorReference = new ConstructorReference();
		constructorReference.check();
		
		System.out.println( "*****Checcking Method reference with parameter" );
		ConstructorReferenceWithParameter constructorReferenceWithParameter = new ConstructorReferenceWithParameter();
		constructorReferenceWithParameter.check1();
		
		System.out.println( "********All Testing*******" );
		TestAll testAll = new TestAll();
		testAll.see();
	}
}
