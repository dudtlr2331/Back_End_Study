package org.example.di.config;

import org.example.di.model1.DeptDAO;
import org.example.di.model2.ListAction;
import org.springframework.context.annotation.Bean;

public class BeanConfig {
    @Bean
    public ListAction listAction() {
        DeptDAO dao = new DeptDAO();
        return new ListAction(dao);
    }
}
