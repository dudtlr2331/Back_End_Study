package org.example.restweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<EmpTO> listEmp() {

		String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
		List<EmpTO> lists = jdbcTemplate.query( sql, new BeanPropertyRowMapper<EmpTO>( EmpTO.class ) );

		return lists;
	}

	public List<EmpTO> listEname(String ename) {

		String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where ename like ?";
		List<EmpTO> lists = jdbcTemplate.query( sql, new BeanPropertyRowMapper<EmpTO>( EmpTO.class ), ename + "%" );

		return lists;
	}
}
