package org.example.jdbc.model1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class EmpDAO {

    @Autowired
    private DataSource dataSource;

    public ArrayList<EmpTO> listEmp(){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<EmpTO> lists = new ArrayList<>();

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
