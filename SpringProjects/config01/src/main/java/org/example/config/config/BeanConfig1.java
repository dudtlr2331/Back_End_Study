package org.example.config.config;

import org.example.config.model.HelloBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import( value = { BeanConfig2.class } )
public class BeanConfig1 {
	@Bean
	public HelloBean1 helloBean1() {
		return new HelloBean1();
	}

	@Bean
	public HelloBean1 helloBean() {
		return new HelloBean1();
	}
}
