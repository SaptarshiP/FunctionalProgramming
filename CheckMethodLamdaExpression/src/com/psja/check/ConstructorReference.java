package com.psja.check;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface Information{
	public Employee setObject();
}

class Employee{
	
	private String name;
	private String phnum;
	
	Employee(){
		super();
		this.name = "DEFAULT_NAME";
		this.phnum = "DEFAULT_PHNUM";
	}
	
	Employee( String name, String phnum ){
		super();
		this.name = name;
		this.phnum = phnum;
	}
	public 	void showInfo() {
		System.out.println( "name:"+this.name+" phone number:"+this.phnum );
	}
}

public class ConstructorReference {

	public Employee methodReferenceInformation() {
		return new Employee();
	}
	
	public Employee methodReferenceInformationWithParameter() {
		return new Employee( "psja", "12345678" );
	}
	
	public void check() {
		
		ConstructorReference constructorReference = new ConstructorReference();
		Information i1 = ()-> new Employee();
		Information i2 = ()-> new Employee( "name_lamda", "phnum_lamda" );
		i1.setObject().showInfo();
		i2.setObject().showInfo();
		
		Information i3 = constructorReference::methodReferenceInformation;
		Information i4 = constructorReference::methodReferenceInformationWithParameter;
		i3.setObject().showInfo();
		i4.setObject().showInfo();
	
	}
	
}
