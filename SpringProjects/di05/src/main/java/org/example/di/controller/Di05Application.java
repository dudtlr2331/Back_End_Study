package org.example.di.controller;

import org.example.di.model1.BoardTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class Di05Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Di05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		BoardTO to = new BoardTO();
		to.setSeq( 1 );
		to.setSubject( "제목 1" );

		System.out.println( "seq :  " + to.getSeq() );
		System.out.println( "subject :  " + to.getSubject() );
		 */

		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext( "classpath:context1.xml" );

		BoardTO to = (BoardTO) ctx.getBean( "to" );
		System.out.println( to.getSeq() );
		System.out.println( to.getSubject() );

		ctx.close();
	}
}
