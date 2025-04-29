package org.example.di.controller;

import org.example.di.config.BeanConfig;
import org.example.di.config.BeanConfig2;
import org.example.di.model2.BoardListTO;
import org.example.di.model2.BoardTO;
import org.example.di.model2.WriteAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Di09Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di09Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BeanConfig2.class);

//        BoardTO boardTO = (BoardTO) ctx.getBean("boardTO");
//        System.out.println(boardTO);
//        System.out.println(boardTO.getSeq());
//        System.out.println(boardTO.getSubject());

        WriteAction action = (WriteAction) ctx.getBean("writeAction");
        action.execute();

        BoardListTO listTO1 = (BoardListTO) ctx.getBean("listTO1");
        for(String user : listTO1.getUserLists()) {
            System.out.println(user);
        }

        for(BoardTO to : listTO1.getBoardList()) {
            System.out.println(to.getSeq());
            System.out.println(to.getSubject());
        }

        ctx.close();
    }
}
