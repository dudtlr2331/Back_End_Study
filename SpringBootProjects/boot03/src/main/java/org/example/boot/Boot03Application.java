package org.example.boot;

import org.example.boot.config.BeanConfig;
import org.example.boot.service.DatabaseService;
import org.example1.config.BeanConfig2;
import org.example2.service.DatabaseService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Boot03Application implements CommandLineRunner {

//    @Autowired
//    private BeanConfig beanConfig;

//    @Autowired
//    private DatabaseService databaseService;

    @Autowired
    private BeanConfig2 beanConfig2;

    @Autowired
    private DatabaseService2 databaseService2;

    public static void main(String[] args) {
        SpringApplication.run(Boot03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("BeanConfig : " + beanConfig);
//        System.out.println("DatabaseService : " + databaseService);
        System.out.println("BeanConfig2 : " + beanConfig2);
        System.out.println("DatabaseService2 : " + databaseService2);
    }
}
