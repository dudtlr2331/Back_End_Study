package jdbc1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx13 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            DatabaseMetaData dbmd = conn.getMetaData(); //데이터베이스 연결에 대한 정보를 알 수 있다.

            System.out.println(dbmd.getDatabaseProductName());
            System.out.println(dbmd.getDatabaseProductVersion());

            System.out.println(dbmd.getDriverName());
            System.out.println(dbmd.getDriverVersion());

            System.out.println(dbmd.getURL());
            System.out.println(dbmd.getUserName());

        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (conn != null) try{ conn.close(); } catch (SQLException e) {}
        }
    }
}
