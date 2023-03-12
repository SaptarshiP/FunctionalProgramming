package com.psja.FunctionalInterface;

import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;

class EmployeeCheck{
	private String empId;
	private String empName;
	
	EmployeeCheck(){
		super();
	}
	EmployeeCheck( String empId, String empName ){
		this.empId = empId;
		this.empName = empName;
	}
	public static EmployeeCheck builder() {
		return new EmployeeCheck();
	}
	public EmployeeCheck EmpId( String empId ) {
		this.empId = empId;
		return this;
	}
	public EmployeeCheck EmpName( String empName ) {
		this.empName = empName;
		return this;
	}
	public String getEmpId() {
		return this.empId;
	}
	public String getEmpName() {
		return this.empName;
	}
	public EmployeeCheck build() {
		return new EmployeeCheck( this.empId, this.empName );
	}
}

public class CheckPredicate {

	public boolean testPredicate( EmployeeCheck emp ) {
		return emp.getEmpId().equals("12");
	}
	
	public void chpl() {
		Predicate<Integer> pr1 = ( num )-> num>10 && num<100;
		Predicate<String> pr2 = ( str )->str.equals("PSJA");
		Predicate<EmployeeCheck> pr3 = new Predicate<EmployeeCheck>() {
				public boolean test( EmployeeCheck empCheck ) {
					return empCheck.getEmpName().contentEquals( "PSJA" );
				}
			};
		CheckPredicate checkPredicate = new CheckPredicate();
		Predicate<EmployeeCheck> pr4 = checkPredicate::testPredicate;
		Predicate<EmployeeCheck> pr5 = (emp)->{
			return emp.getEmpName().equalsIgnoreCase("Psja8");
		};
		Predicate<EmployeeCheck> pr6 = (emp)-> emp.getEmpName().equalsIgnoreCase("psja4");
		
		List<EmployeeCheck> empCheckList = new ArrayList<>();
		for ( Integer i=0; i<10; i++ ) {
			empCheckList.add( EmployeeCheck.builder()
											.EmpId( i.toString() )
											.EmpName( "PSJA"+i )
											.build() );
		}
		System.out.println(pr1.test(8));
		System.out.println("******************************************************************");
		System.out.println( pr2.test("PSJ") );
		System.out.println("********************************************************************");
		for ( Integer i = 0; i<10; i++ ) {
			if (pr3.test( empCheckList.get( i ) )) System.out.println( empCheckList.get(i).getEmpName() );
		}
		System.out.println("*********************************************************************");
		for ( Integer i = 0; i<10; i++ ) {
			if ( pr4.test( empCheckList.get( i ) ) ) System.out.println( empCheckList.get(i).getEmpId() );
		}
		System.out.println("********************************************************************");
		for ( Integer i = 0; i<10; i++ ) {
			if ( pr5.test( empCheckList.get( i ) ) ) System.out.println( empCheckList.get(i).getEmpName() );
		}
		System.out.println("********************************************************************");
		for ( Integer i = 0; i<10; i++ ) {
			if ( pr6.test( empCheckList.get( i ) ) ) System.out.println( empCheckList.get(i).getEmpName() );
		}
			
	}
}
