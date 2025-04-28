package org.example;

import java.sql.*;

public class ZipcodeSearch {
    public static void main(String[] args) {

        // 입력값 검사
        if (args.length != 1 ) {
            System.out.println( "Usage: java ZipcodeSearchEx01 동이름" );
            System.exit(0);
        }

        if (args[0].length() < 2 ) {
            System.out.println( "동이름을 2자 이상 입력하세요" );
            System.exit(0);
        }

        String url = "jdbc:mysql://localhost:3306/project";
        String user = "project";
        String password = "123456";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            conn = DriverManager.getConnection( url, user, password );

            stmt = conn.createStatement();

            //String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like '개포%'";
            String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like '" + args[0] + "%'";

            rs = stmt.executeQuery( sql );

            while( rs.next() ) {
                String zipcode = rs.getString( "zipcode" );
                String sido = rs.getString( "sido" );
                String gugun = rs.getString( "gugun" );
                String dong = rs.getString( "dong" );
                String ri = rs.getString( "ri" );
                String bunji = rs.getString( "bunji" );

                //System.out.println( dong );
                String address = String.format( "[%s] %s %s %s %s %s", zipcode, sido,gugun, dong, ri, bunji );
                System.out.println( address );
            }
        } catch (ClassNotFoundException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (SQLException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
            if( stmt != null ) try { stmt.close(); } catch( SQLException e ) {}
            if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
        }
    }
}
