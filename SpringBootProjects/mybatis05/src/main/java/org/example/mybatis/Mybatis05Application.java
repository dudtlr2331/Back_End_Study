package org.example.mybatis;

import org.example.mybatis.model.EmpDAO;
import org.example.mybatis.model.EmpTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Mybatis05Application implements CommandLineRunner {

    @Autowired
    private EmpDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(Mybatis05Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> map = dao.select1();
        EmpTO to = dao.select2();

        System.out.println("map : " + map);
        System.out.println("to : " + to);
    }
}
