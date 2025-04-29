package org.example.lifecycle.config;

import org.example.lifecycle.model.WriteAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(CustomBeanPostProcessor.class)
public class BeanConfig {

    @Bean(initMethod = "init_method", destroyMethod = "destroy_method")
    public WriteAction writeAction() {
        WriteAction action = new WriteAction();
        action.setWriter("홍길동");
        return action;
    }
}
