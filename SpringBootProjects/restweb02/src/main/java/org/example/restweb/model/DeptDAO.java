package org.example.restweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeptDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DeptTO> listDept(){
        String sql = "select deptno, dname, loc from dept";
        List<DeptTO> lists = jdbcTemplate.query(sql, new BeanPropertyRowMapper<DeptTO>(DeptTO.class));

        return lists;
    }
}
