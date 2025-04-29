package org.example.config.config;

import org.example.config.model.HelloBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

public class BeanConfig2 {
	@Bean
	public HelloBean2 helloBean2() {
		return new HelloBean2();
	}

	@Bean
	public HelloBean2 helloBean() {
		return new HelloBean2();
	}
}
