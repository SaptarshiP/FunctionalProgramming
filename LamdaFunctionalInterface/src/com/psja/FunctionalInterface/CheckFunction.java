package com.psja.FunctionalInterface;

import java.util.function.Predicate;
import java.util.function.Function;

class EmployeeCheckFunction{
	private String empId;
	private String empName;
	
	EmployeeCheckFunction(){
		super();
	}
	EmployeeCheckFunction( String empId, String empName ){
		this.empId = empId;
		this.empName = empName;
	}
	public static EmployeeCheckFunction builder() {
		return new EmployeeCheckFunction();
	}
	public EmployeeCheckFunction EmpId( String empId ) {
		this.empId = empId;
		return this;
	}
	public EmployeeCheckFunction EmpName( String empName ) {
		this.empName = empName;
		return this;
	}
	public String getEmpId() {
		return this.empId;
	}
	public String getEmpName() {
		return this.empName;
	}
	public EmployeeCheckFunction build() {
		return new EmployeeCheckFunction( empId, empName );
	}
}

public class CheckFunction {

	public String toUpperCase( String inp ) {
		return inp.toLowerCase();
	}
	
	public void chFun() {

		Function<String, String> fn1 = ( inp )-> inp+"_check";
		Function< Integer, String > fn2 = ( i )->i.toString();
		CheckFunction chFunction = new CheckFunction();
		Function<String, String> fn3 = chFunction::toUpperCase;
		
		EmployeeCheckFunction emp = EmployeeCheckFunction.builder()
															.EmpId("123")
															.EmpName("PSJA")
															.build();
		
		Function< EmployeeCheckFunction, EmployeeCheckFunction > fn4 = ( em )->{
								
								Predicate< EmployeeCheckFunction > pr1 = ( p )-> p.getEmpId().equals("123");
								if ( pr1.test( em ) )
									em.EmpName( "PSJA8" );
								return em;
							};
							
		String ch1 = "PSJA8";
//		Function<EmployeeCheckFunction, EmployeeCheckFunction> fn5 = new Function<EmployeeCheckFunction, EmployeeCheckFunction>() {
//					public EmployeeCheckFunction apply( EmployeeCheckFunction empCheckFunction ) {
//						Predicate<String> pr1 = (str)->ch1.equals( str );
//						if ( pr1.test( empCheckFunction.getEmpName() ) ) {
//							Function<String, String> fn1 = ( str )->str.concat("_UPDATED");
//							empCheckFunction.EmpName( fn1.apply( empCheckFunction.getEmpName() ) );
//						}
//						return empCheckFunction;
//					}
//				};
		System.out.println( fn1.apply( "PSJA" ) );
		System.out.println( fn2.apply( 8 ) );
		System.out.println( fn3.apply( "PSJA" ) );
		emp = fn4.apply( emp );
		System.out.println( emp.getEmpId() );
		System.out.println( emp.getEmpName() );
		//emp = fn5.apply( emp );
		//System.out.println( emp.getEmpId() );
		//System.out.println( emp.getEmpName() );
	}
}
