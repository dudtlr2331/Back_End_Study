package org.example;

import java.sql.*;

public class EmpEx01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String username = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 로딩 성공");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("데이터베이스 연결 성공");
            stmt = conn.createStatement();

            String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String empno = rs.getString("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                String mgr = rs.getString("mgr");
                String hiredate = rs.getString("hiredate");
                String sal = rs.getString("sal");
                String comm = rs.getString("comm");
                String deptno = rs.getString("deptno");

//                System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t"
//                + hiredate + "\t" + sal + "\t" + comm + "\t" + deptno);

                String data = String.format("insert into emp values(%s, '%s', '%s', %s, '%s', %s, %s, %s)",
                        empno, ename, job, mgr, hiredate, sal, comm, deptno);
                System.out.println(data);

            }

            System.out.println("데이터베이스 연결 성공");

        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if(conn != null) try { conn.close(); } catch (SQLException e) {}
            if(stmt != null) try { stmt.close(); } catch (SQLException e) {}
            if(rs != null) try { rs.close(); } catch (SQLException e) {}
        }
    }
}
