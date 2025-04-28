package org.example.di.controller;

import org.example.di.model3.BoardListTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class ApplicationEx03 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEx03.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext( "classpath:context3.xml" );

		BoardListTO listTO = (BoardListTO) ctx.getBean("listTO");

		for ( String user : listTO.getUserLists() ) {
			System.out.println( user );
		}
	}
}
