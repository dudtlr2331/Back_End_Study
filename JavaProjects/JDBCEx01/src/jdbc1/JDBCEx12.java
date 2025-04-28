package jdbc1;

import java.sql.*;

public class JDBCEx12 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

//            String sql = "select * from emp where deptno = ?";
            String sql = "select * from emp where ename like ?";


            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, 10);
            pstmt.setString(1, "s%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String empno = rs.getString("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");

                System.out.println(empno + "\t" + ename + "\t" + job);
            }

            System.out.println("쿼리 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
        }
    }
}
