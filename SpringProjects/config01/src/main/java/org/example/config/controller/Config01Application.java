package org.example.config.controller;

import org.example.config.config.BeanConfig1;
import org.example.config.config.BeanConfig2;
import org.example.config.model.HelloBean1;
import org.example.config.model.HelloBean2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Config01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Config01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext( BeanConfig1.class, BeanConfig2.class );
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext( BeanConfig1.class );

		HelloBean1 helloBean1 = (HelloBean1)ctx.getBean( "helloBean1" );
		helloBean1.sayHello( "홍길동" );

		HelloBean2 helloBean2 = (HelloBean2)ctx.getBean( "helloBean2" );
		helloBean2.sayHello( "장길산" );

		// 오버라이팅
		HelloBean1 helloBean = (HelloBean1)ctx.getBean( "helloBean" );
		//HelloBean2 helloBean = (HelloBean2)ctx.getBean( "helloBean" );
		helloBean.sayHello( "임꺽정" );

		ctx.close();
	}
}
