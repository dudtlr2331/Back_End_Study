package org.example.jdbc;

import org.example.jdbc.model1.DeptDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jdbc04Application implements CommandLineRunner {

    @Autowired
    private DeptDAO dao;


    public static void main(String[] args) {
        SpringApplication.run(Jdbc04Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello JDBC : " + dao);
        dao.viewDataSource();

    }
}
