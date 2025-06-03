package org.example.mybatis;

import org.example.mybatis.dao.MyBatisRepository;
import org.example.mybatis.service.MyBatisService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mybatis06Application implements CommandLineRunner {

    @Autowired
    private MyBatisRepository myBatisRepository;

    @Autowired
    private MyBatisService myBatisService;

    public static void main(String[] args) {
        SpringApplication.run(Mybatis06Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        String result = myBatisRepository.select();
//        System.out.println("result : " + result);
        myBatisService.select();
        myBatisService.selectList();
    }
}
