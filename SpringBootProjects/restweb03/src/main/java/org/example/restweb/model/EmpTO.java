package org.example.restweb.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpTO {
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;
}
