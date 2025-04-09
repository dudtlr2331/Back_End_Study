package org.example;

import java.sql.*;
import java.util.Scanner;

public class EnameSearchEx01 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner( System.in );
        System.out.print( "사원이름 : " );
        String strEname = sc.nextLine();

        System.out.println( "입력 : " + strEname );

        sc.close();

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );

            conn = DriverManager.getConnection( url, user, password );

            String sql = "select empno, ename, job, sal*12 + ifnull(comm, 0) annsal, hiredate, d.deptno, d.loc from emp e inner join dept d using (deptno) where ename like ?";

            pstmt = conn.prepareStatement( sql );
            pstmt.setString( 1, strEname + "%" );

            rs = pstmt.executeQuery();

            while( rs.next() ) {
                String empno = rs.getString( "empno" );
                String ename = rs.getString( "ename" );
                String job = rs.getString( "job" );
                String annsal = rs.getString( "annsal" );
                String hiredate = rs.getString( "hiredate" );
                String deptno = rs.getString( "deptno" );
                String loc = rs.getString( "loc" );

                String data = String.format( "%s %s %s %s %s %s %s", empno, ename, job, annsal, hiredate, deptno, loc );
                System.out.println( data );
            }
        } catch (ClassNotFoundException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (SQLException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
            if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
            if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
        }
    }
}