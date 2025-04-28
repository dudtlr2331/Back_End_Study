package org.example.di.controller;

import org.example.di.model2.WriteAction;
import org.example.di.model3.BoardListTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class Application2 implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application2.class, args);
    }

    @Override
        public void run(String... args) throws Exception {
        ArrayList<String> userList = new ArrayList<String>();
        userList.add("홍길동");
        userList.add("박문수");

        BoardListTO listTO = new BoardListTO();
        listTO.setUserList(userList);

        for(String user : userList) {
            System.out.println(user);
        }
    }
}
