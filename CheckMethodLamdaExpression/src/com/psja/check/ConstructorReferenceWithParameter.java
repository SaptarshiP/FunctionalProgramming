package com.psja.check;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface informationCheck{
	public EmployeeGet getInformation();
}
@FunctionalInterface
interface informationWithParameter{
	public EmployeeGet getInformation( String name, String phnum );
}

class EmployeeGet{

	private String name;
	private String phnum;
	
	EmployeeGet(){
		super();
		this.name = "DEFAULT";
		this.phnum = "DEFAULT";
	}
	EmployeeGet( String name, String phnum ){
		this.name = name;
		this.phnum = phnum;
	}
	public void showInfo() {
		System.out.println( "name:"+name+", phnum:"+phnum );
	}
}
public class ConstructorReferenceWithParameter {

	public EmployeeGet getEmployee() {
		return new EmployeeGet();
	}
	public EmployeeGet getEmployee( String name, String phnum ) {
		return new EmployeeGet( name, phnum );
	}
	
	public void check1() {
		
		informationCheck inf1 = ()-> new EmployeeGet();
		informationWithParameter inf2 = ( name, phnum )-> new EmployeeGet( name, phnum );
		inf1.getInformation().showInfo();;
		inf2.getInformation("lamda_with_parameter", "123456789").showInfo();
		
		ConstructorReferenceWithParameter constructorReferenceWithParameter = new ConstructorReferenceWithParameter();
		informationCheck inf3 = constructorReferenceWithParameter::getEmployee;
		informationWithParameter inf4 = constructorReferenceWithParameter::getEmployee;
		
		inf3.getInformation().showInfo();
		inf4.getInformation("method_reference_with_parameter", "123456789").showInfo();
	}
	
}
