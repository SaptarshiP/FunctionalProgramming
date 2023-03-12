package com.psja.FunctionalInterface;

import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.ArrayList;

class Employee{
	private String empId;
	private String empName;
	
	public Employee() {
		super();
	}
	public Employee( String empId, String empName ) {
		this.empId = empId;
		this.empName = empName;
	}
	
	public static Employee builder() {
		return new Employee();
	}
	public Employee EmpId( String empId ) {
		this.empId = empId;
		return this;
	}
	public Employee EmpName( String empName ) {
		this.empName = empName;
		return this;
	}
	public String getEmpId() {
		return this.empId;
	}
	public String getEmpName() {
		return this.empName;
	}
	public Employee build() {
		return new Employee( this.empId, this.empName );
	}
	
}

public class CheckConsumer {

	private String product = "PSJA";
	
	public static void methodReference( String pr ) {
		System.out.println( "In method reference"+ pr );
	}
	
	public void checkCon() {
		
		Consumer<Integer> c1 = ( a )->System.out.println( a );
		Consumer<String> c2 = ( product )->System.out.println( product.length() );
		Consumer<String> c3 = new Consumer<String>(){
					public void accept( String a ) {
						System.out.println( "In anonymous class"+ a );
					}
				};
		Consumer<String> c4 = CheckConsumer::methodReference;
		
		Consumer<Employee> c5 = ( emp )->{
			System.out.println( "-------------------------------" );
			System.out.println( "Employee Id:"+ emp.getEmpId() );
			System.out.println( "Employee Name:"+ emp.getEmpName() );
		};
		BiConsumer<String, String> biConsumer = (a, b)->{
								System.out.println(a+" "+b);
		};
		
		List<Employee> empList = new ArrayList<>();
		for ( Integer i = 0; i<10; i++ ) {
			empList.add( Employee.builder()
										.EmpId( i.toString() )
										.EmpName( product+" "+i.toString() )
										.build() );
		}
		
		c1.accept(10);
		c2.accept( product );
		c3.accept( product );
		c4.accept( product );
		empList.forEach( c5 );
		biConsumer.accept("Psja_", "PSJA");
	}
	
}
