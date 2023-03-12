package com.psja;

import java.util.Optional;

public class CheckOp {

	public void check() {
		Optional<String> optional = Optional.ofNullable( null );
		
		optional.ifPresent( data->System.out.println( data.length() ) );
		System.out.println( optional.orElseGet( ()->"SUPPLIER_PSJA" ) ); 
	}
	
}
