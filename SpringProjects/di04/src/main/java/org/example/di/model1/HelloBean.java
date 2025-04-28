package org.example.di.model1;

public class HelloBean {

	// default 생성자
	/*
	public HelloBean() {
		System.out.println( "HelloBean default 생성자 호출" );
	}
	*/

	public HelloBean(String name) {
		System.out.println( "HelloBean(String name) 생성자 호출" );
	}

	//public HelloBean(String firstName, String lastName) {
	//	System.out.println( "HelloBean(String firstName, String lastName) 생성자 호출" );
	//}

	public HelloBean(String name, Integer age) {
		System.out.println( "HelloBean(String name, Integer age) 생성자 호출" );
	}
}
