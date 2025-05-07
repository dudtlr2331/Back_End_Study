package org.example.jdbc;

import org.example.jdbc.model.JdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Jdbc05Application implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(Jdbc05Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("jdbcTemplate = " + jdbcTemplate);
        /*
            update() - insert, update, delete, ddl...
            query() - select
                    queryForList() / queryForMap()
                    queryForObject()
        */

        // select now() as now
//        String now = jdbcTemplate.queryForObject("select now() as now", String.class);
//        System.out.println("now : " + now);

//        List<Map<String, Object>> results = jdbcTemplate.queryForList("show databases");
//        Map<String, Object> result = results.get(0);
//        System.out.println("result : " + result);
//        System.out.println("data : " + result.get("Database"));

//        for(Map<String, Object> result : results) {
//            System.out.println("database : " + result.get("Database"));
//        }

        dao.jdbc();
    }
}
