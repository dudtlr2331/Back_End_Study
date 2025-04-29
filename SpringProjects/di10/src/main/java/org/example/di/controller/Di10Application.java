package org.example.di.controller;

import org.example.di.config.BeanConfig;
import org.example.di.model1.DeptDAO;
import org.example.di.model1.DeptTO;
import org.example.di.model2.Action;
import org.example.di.model2.ListAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class Di10Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di10Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 모델 1 방식
//        DeptDAO dao = new DeptDAO();
//        ArrayList<DeptTO> lists = dao.deptList();
//
//        for(DeptTO to : lists){
//            System.out.println(to.getDeptno());
//        }

//        모델 2 방식
//        DeptDAO dao = new DeptDAO();
//
//        Action action = new ListAction(dao);
//        action.execute();

        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BeanConfig.class);

        Action action = (Action) ctx.getBean("listAction");
//        action.execute();

        ArrayList<DeptTO> lists = action.listDept();
        for(DeptTO to : lists){
            System.out.println(to.getDeptno() + "\t" + to.getDname() + "\t" + to.getLoc());
        }

        ctx.close();
    }
}
