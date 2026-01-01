package org.example.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.*;

@SpringBootApplication
public class Mybatis02Application implements CommandLineRunner {

    @Autowired
    private SqlSession sqlSession;

    public static void main(String[] args) {
        SpringApplication.run(Mybatis02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("sqlSession : " + sqlSession);
//
//        String result = sqlSession.selectOne("select");
//        System.out.println("result : " + result);

//        Map<String, Object> map = sqlSession.selectOne("selectone");
//        Map<String, Object> map = sqlSession.selectOne("selectoneparam1", 10);

//        Map<String, Object> params = new HashMap<>();
//        params.put("deptno", 30);
//        params.put("dname", "SALES");
//
//        Map<String, Object> map = sqlSession.selectOne("selectoneparam2", params);
//
//
//
//        System.out.println("map : " + map.size());

//        System.out.println(map.get("deptno"));
//        System.out.println(map.get("dname"));
//        System.out.println(map.get("loc"));

//        Set<String> keys = map.keySet();
//        for (String key : keys) {
//            System.out.println(map.get(key));
//        }

        List<Map<String, Object>> maps = sqlSession.selectList("selectlist");

//        Map<String, Object> data = maps.get(0);
//        System.out.println(data.get("deptno"));
//        System.out.println(data.get("dname"));
//        System.out.println(data.get("loc"));

        for (Map<String, Object> map : maps) {
            System.out.printf("%s\t%s\t%s\n", map.get("deptno"), map.get("dname"), map.get("loc"));
        }
    }
}
