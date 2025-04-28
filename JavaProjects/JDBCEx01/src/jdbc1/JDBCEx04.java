package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx04 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;

        try {
            // 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 로딩 성공");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공");

            // Statement / PreparedStatement / CallableStatement
            // Select / 기타
            // insert / update / delete

            stmt = conn.createStatement();
//            stmt.executeUpdate("insert into dept2 values (51, '개발부', '서울')");
//            String sql = "insert into dept2 values (52, '개발부', '부산')";

            String deptno = "53";
            String dname = "연구부";
            String loc = "대전";

//            String sql = "insert into dept2 values (" + deptno + ",'" + dname + "', '" + loc + "')";
            String sql = String.format("insert into dept2 values(%s,'%s','%s')", deptno, dname, loc);
            System.out.println(sql);
//            stmt.executeUpdate(sql);

            System.out.println("실행 성공");

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패 : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally { // 반드시 연결했으면 해제까지...
            if (conn != null) try{ conn.close(); } catch (SQLException e) {}
            if (stmt != null) try{ stmt.close(); } catch (SQLException e) {}
        }
    }
}
