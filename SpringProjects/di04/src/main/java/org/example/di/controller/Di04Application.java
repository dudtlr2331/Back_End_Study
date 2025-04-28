package org.example.di.controller;

import org.example.di.model1.HelloBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class Di04Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Di04Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext( "classpath:context.xml" );

		//HelloBean hello1 = (HelloBean) ctx.getBean("hello1");
		//HelloBean hello2 = (HelloBean) ctx.getBean("hello2");
		//HelloBean hello3 = (HelloBean) ctx.getBean("hello3");
		HelloBean hello4 = (HelloBean) ctx.getBean("hello4");

		ctx.close();
	}
}
