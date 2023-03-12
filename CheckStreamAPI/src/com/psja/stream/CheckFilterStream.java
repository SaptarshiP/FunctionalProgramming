package com.psja.stream;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;

public class CheckFilterStream<T> {

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
	}
	
	public static Boolean filter1( Integer i ) {
		return i%2 == 0;
	}
	public boolean filter2( Employee emp ) {
		return emp.getEmpId().equalsIgnoreCase( "12345" );
	}
	public void println( T data ) {
		System.out.println( "here"+data );
	}
	

	
	public void checkFil() {
		List<String> iList = Arrays.asList( "PSJA1", "PSJA2", "DS", "DE" );
		iList = iList.stream()
						.filter( data-> data.equalsIgnoreCase( "PSJA1" ) )
						.collect( Collectors.toList() );
		
		System.out.println( iList );
		
		Stream<Integer> stream = Stream.of( 1, 2, 3, 4, 5, 6, 7, 8, 9 );
		Stream<Integer> streamInt = stream.filter( data->data%2 == 0 ).limit( 2 );
		streamInt.forEach( new Consumer<Integer>() {
			public void accept( Integer num ) {
				System.out.println(num);
			}
		} );
		Stream<Integer> stream1 = Stream.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
		stream1 = stream1.filter( CheckFilterStream::filter1 )
							.skip( 2 );
		System.out.println("***********************************");
		stream1.forEach( num-> System.out.print( num+"," ) );
		System.out.println();
		Stream<Integer> stream2 = Stream.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("***********Peek Check************");
		Stream<Integer> strList = stream2.filter( new Predicate<Integer>() {
										public boolean test( Integer value ) {
											return value%2 == 0;
										}
									} ).limit(2)
									.peek( System.out::println );
		CheckFilterStream<Integer> chFilterStream1 = new CheckFilterStream<>();
		strList.forEach( chFilterStream1::println );
		
		CheckFilterStream<T> chFilterStream2 = new CheckFilterStream<>();
		Employee employee = chFilterStream2.new Employee( "12345", "PSJA3" );
		Stream<Employee> empStream = Stream.of( employee );
		CheckFilterStream<String> strFilterStream = new CheckFilterStream<>();
		empStream.filter( chFilterStream2::filter2 )
					.map( new Function< Employee, Employee >() {
						public Employee apply( Employee emp ) {
							emp.EmpName( "PSJA8" );
							return emp;
						}
					} )
					.limit(1)
					.map( new Function< Employee, String >() {
						public String apply( Employee emp ) {
							return emp.getEmpName();
						}
					} )
					.collect( Collectors.toList() )
					.forEach( strFilterStream::println );
		
		//flatmap
		
		Stream< Stream<Integer> > streamStream = Stream.of( Stream.of( 10, 11 ), 
															Stream.of( 12, 13 ),
															Stream.of( 14, 15 ) );
		streamStream
				.flatMap( num -> num.map( data->data+1 ) )
				.forEach( chFilterStream1::println );
		
		Stream< Stream<String> > str4 = Stream.of( Stream.of( "saptarshi", "pramanick" ), 
													Stream.of("Pampa", "Pramanick"),
													Stream.of("Shyamal", "pramanick") );
		str4
			.flatMap( data->data
								.map(
										new Function< String, String >() {
											public String apply( String value ) {
												return value.substring(0, 1);
											}
										}
									) )
			.collect( Collectors.toList() )
			.forEach( strFilterStream::println );
		
		//anyMatch
		System.out.println( "Here in the matching" );
		Stream< Stream< String > > str5 = Stream.of( Stream.of( "saptarshi", "pramanick" ),
														Stream.of( "shyamal", "pramanick" ),
														Stream.of( "pampa", "pramanick" ));
		String ch1 = "PAMPA";
		Boolean res1 = str5
							.flatMap( data->data.map(
												new Function<String, String>() {
												public String apply( String value ) {
														return value.toUpperCase();
												}
												}) )
							.anyMatch( data-> data.equals( ch1 ) );
		System.out.println( "result of anymatch:" + res1 );
		
		//reduce
		System.out.println( "Here in the reduce method" );
		Stream<Integer> str6 = Stream.of( 1, 2, 3, 4, 5 );
		System.out.println( str6.reduce(0, (d1, d2) -> d1+d2) );
		
		Stream<Integer> str7 = Stream.of( 1,2,3,4 );
		Optional<Integer> opt = str7.reduce( (d1, d2)->d1*d2 );
		if ( opt.isPresent() )
			System.out.println( opt.get() );
		
		//toArray
	}
	
}
