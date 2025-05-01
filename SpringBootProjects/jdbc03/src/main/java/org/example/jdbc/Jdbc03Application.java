package org.example.jdbc;

import org.example.jdbc.model.DeptDAO;
import org.example.jdbc.model.DeptTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Jdbc03Application implements CommandLineRunner {

    @Autowired
    private DeptDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(Jdbc03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<DeptTO> list = dao.listDept();

        for (DeptTO to : list) {
            System.out.println(to.toString());
        }
    }
}
