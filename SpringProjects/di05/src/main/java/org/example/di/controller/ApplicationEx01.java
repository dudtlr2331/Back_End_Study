package org.example.di.controller;

import org.example.di.model1.BoardTO;
import org.example.di.model2.WriteAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class ApplicationEx01 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEx01.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext( "classpath:context2.xml" ) ;

		WriteAction writeAction = (WriteAction)ctx.getBean( "writeAction" );
		writeAction.execute();

		ctx.close();
	}
}
