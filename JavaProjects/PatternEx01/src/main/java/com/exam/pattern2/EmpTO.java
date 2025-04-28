package com.exam.pattern2;

public class EmpTO {
    // 테이블의 데이터를 저장 / 이동할 클래스
    // 1. 테이블의 컬럼대로
    // 2. 사용되는 select문과 유사하게
    //  empno, ename, job, sal*12 + ifnull(comm, 0) as annsal, hiredate, deptno

    private String empno;
    private String ename;
    private String job;
    private String annsal;
    private String hiredate;
    private String deptno;

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAnnsal() {
        return annsal;
    }

    public void setAnnsal(String annsal) {
        this.annsal = annsal;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "EmpTO{" +
                "empno='" + empno + '\'' +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", annsal='" + annsal + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", deptno='" + deptno + '\'' +
                '}';
    }
}
