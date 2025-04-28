package org.example.di.controller;

import org.example.di.model2.WriteAction;
import org.example.di.model3.ListAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class AppicatonEx02 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppicatonEx02.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext( "classpath:context3.xml" );

		ListAction listAction = (ListAction) ctx.getBean("listAction");
		listAction.execute();

		ctx.close();
	}
}
