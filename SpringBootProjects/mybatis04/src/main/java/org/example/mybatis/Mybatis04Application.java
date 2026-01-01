package org.example.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mybatis04Application implements CommandLineRunner {

    @Autowired
    private SqlSession sqlSession;

    public static void main(String[] args) {
        SpringApplication.run(Mybatis04Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
