package org.example.mybatis07;

import org.example.mybatis07.mapper.MyBatisMapper;
import org.example.mybatis07.service.MyBatisSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mybatis07Application implements CommandLineRunner {

    @Autowired
    private MyBatisSerivce myBatisSerivce;

    public static void main(String[] args) {
        SpringApplication.run(Mybatis07Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        myBatisSerivce.select();
//        myBatisSerivce.selectList();
//        myBatisSerivce.insert();
//        myBatisSerivce.update();
        myBatisSerivce.delete();
    }
}
