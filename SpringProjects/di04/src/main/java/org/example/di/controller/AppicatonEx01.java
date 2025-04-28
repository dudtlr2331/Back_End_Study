package org.example.di.controller;

import org.example.di.model2.BoardTO;
import org.example.di.model2.WriteAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class AppicatonEx01 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppicatonEx01.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 디폴트 생성자 호출
		//WriteAction writeAction1 = new WriteAction();
		//writeAction1.execute();

		// 오버로딩 생성자 호출
		//BoardTO to = new BoardTO();
		//WriteAction writeAction2 = new WriteAction( to );
		//writeAction2.execute();

		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext( "classpath:context2.xml" );

		//WriteAction writeAction1 = (WriteAction) ctx.getBean("writeAction1" );
		//writeAction1.execute();

		//WriteAction writeAction2 = (WriteAction) ctx.getBean("writeAction2" );
		//writeAction2.execute();

		WriteAction writeAction3 = (WriteAction) ctx.getBean("writeAction3" );
		writeAction3.execute();

		ctx.close();
	}
}
