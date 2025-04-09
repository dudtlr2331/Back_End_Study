package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class EmpEx02 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String username = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        BufferedWriter writer = null;

        try {
            // 파일 작성 준비
            writer = new BufferedWriter(new FileWriter("./emp.sql"));

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

                String data = String.format("insert into emp values(%s, '%s', '%s', %s, '%s', %s, %s, %s)",
                        empno, ename, job, mgr, hiredate, sal, comm, deptno);

                // 파일에 쓰기
                writer.write(data + System.lineSeparator());
            }

        }catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            try { if (writer != null) writer.close(); } catch (IOException e) {}
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}
