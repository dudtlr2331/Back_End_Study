package org.example.di.controller;

import org.example.di.model2.WriteAction;
import org.example.di.model3.BoardListTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class ApplicationEx02 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEx02.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ArrayList<String> userLists = new ArrayList<String>();
		userLists.add( "홍길동" );
		userLists.add( "장길산" );

		BoardListTO listTO = new BoardListTO();
		listTO.setUserLists( userLists );

		for ( String user : userLists ) {
			System.out.println( user );
		}



	}
}
