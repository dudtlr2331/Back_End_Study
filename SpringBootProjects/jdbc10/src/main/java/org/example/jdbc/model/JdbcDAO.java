package org.example.jdbc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public void jdbc(){
        System.out.println("dataSource : " + dataSource);
        System.out.println("jdbcTemplate : " + jdbcTemplate);

        String result = jdbcTemplate.queryForObject("select now() as now", String.class);
        System.out.println("현재시간 : " + result);
    }
}
