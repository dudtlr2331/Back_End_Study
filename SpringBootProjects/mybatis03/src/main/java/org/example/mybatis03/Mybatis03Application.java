package org.example.mybatis03;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis03.model.DeptTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Mybatis03Application implements CommandLineRunner {

    @Autowired
    private SqlSession sqlSession;

    public static void main(String[] args) {
        SpringApplication.run(Mybatis03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String result = sqlSession.selectOne("select");
        System.out.println("result : " + result);

//        DeptTO to = sqlSession.selectOne("selectone");
        DeptTO paramTO = new DeptTO();
        paramTO.setDeptno("30");
        paramTO.setDname("SALES");
        DeptTO to = sqlSession.selectOne("selectone1", paramTO);

        System.out.println(to.getDeptno());
        System.out.println(to.getDname());
        System.out.println(to.getLoc());

//        List<DeptTO> depts = sqlSession.selectList("selectlist");
//        for (DeptTO dept : depts) {
//            System.out.printf("%s\t%s\t%s\n", dept.getDeptno(), dept.getDname(), dept.getLoc());
//        }
    }
}
