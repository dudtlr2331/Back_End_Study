package org.example.di.model1;

import java.sql.*;
import java.util.ArrayList;

public class DeptDAO {
	private Connection conn;

	public DeptDAO() {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "victory123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("[에러] " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[에러] " + e.getMessage());
		}
	}

	public ArrayList<DeptTO> deptList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<DeptTO> lists = new ArrayList<>();

		try {
			String sql = "select deptno, dname, loc from dept";
			pstmt = conn.prepareStatement( sql );

			rs = pstmt.executeQuery();

			while( rs.next() ) {
				DeptTO to = new DeptTO();
				to.setDeptno( rs.getString( "deptno" ) );
				to.setDname( rs.getString( "dname" ) );
				to.setLoc( rs.getString( "loc" ) );

				lists.add( to );
			}
		} catch (SQLException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}

		return lists;
	}
}
