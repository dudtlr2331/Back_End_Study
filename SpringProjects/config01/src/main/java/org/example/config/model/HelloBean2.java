package org.example.config.model;

public class HelloBean2 {
	public HelloBean2() {
		System.out.println( "HelloBean2 호출" );
	}

	public void sayHello(String name) {
		System.out.println( "Hello " + name );
	}
}
