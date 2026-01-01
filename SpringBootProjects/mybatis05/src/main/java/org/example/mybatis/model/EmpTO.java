package org.example.mybatis.model;

import lombok.Data;

@Data
public class EmpTO {
    private String empno;
    private String ename;
    private String job;
    private String mgr;
    private String hiredate;
    private String sal;
    private String comm;
    private String deptno;
}
