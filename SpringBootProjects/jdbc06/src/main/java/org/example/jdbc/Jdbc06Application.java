package org.example.jdbc;

import org.example.jdbc.model.DeptDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jdbc06Application implements CommandLineRunner {

    @Autowired
    private DeptDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(Jdbc06Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dao.listDepts();
    }
}
