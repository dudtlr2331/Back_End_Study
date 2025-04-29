package org.example.autowired.controller;

import org.example.autowired.config.BeanConfig3;
import org.example.autowired.model3.WriteAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Autowired01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Autowired01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx
			= new AnnotationConfigApplicationContext( BeanConfig3.class );

		WriteAction writeAction = (WriteAction) ctx.getBean( "writeAction" );
		writeAction.viewDao();

		ctx.close();
	}
}
