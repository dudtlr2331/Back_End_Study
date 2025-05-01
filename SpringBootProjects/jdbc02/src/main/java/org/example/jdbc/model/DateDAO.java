package org.example.jdbc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DateDAO {

    @Autowired
    private DataSource dataSource;

    public DateDAO() {
        System.out.println("1. dataSource : " + dataSource);
    }

    public void jdbc(){
        System.out.println("2. dataSource : " + dataSource);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();

            String url = "select now() as now";
            pstmt = conn.prepareStatement(url);

            rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println(rs.getString("now"));
            }
        }catch (SQLException e){
            System.out.println("[에러] " + e.getMessage());
        }finally {
            if(rs != null) try{ rs.close(); } catch(SQLException e){}
            if(pstmt != null) try{ pstmt.close(); } catch(SQLException e){}
            if(conn != null) try{ conn.close(); } catch(SQLException e){}
        }
    }
}
