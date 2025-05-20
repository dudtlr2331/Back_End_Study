package org.example.restweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDAO {

    // 영속성 (Persistance)
    // jdbcTemplate(JDBC) / MyBatis / JPA

    // 트랜잭션
    // 

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmpTO> listEmp(){
        String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
        List<EmpTO> lists = jdbcTemplate.query(sql, new BeanPropertyRowMapper<EmpTO>(EmpTO.class));

        return lists;
    }
}
