package org.example.model1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
    private DataSource dataSource;

    public BoardDAO() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            this.dataSource = (DataSource) envCtx.lookup("jdbc/mysql1");
        } catch (NamingException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }

    public void boardWrite() {

    }

    public int boardWriteOk(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;

        // 정상 : 0 / 비정상 : 1
        int flag = 1;

        try{
            conn = this.dataSource.getConnection();

            String sql = "insert into emot_board1 values(0, ?, ?, ?, md5(?), ?, ?, 0, ?, now());";
            pstmt = conn.prepareStatement( sql );

            pstmt.setString( 1, to.getSubject() );
            pstmt.setString( 2, to.getWriter() );
            pstmt.setString( 3, to.getMail() );
            pstmt.setString( 4, to.getPassword() );
            pstmt.setString( 5, to.getContent() );
            pstmt.setString( 6, to.getEmot() );
            pstmt.setString( 7, to.getWip() );

            if(pstmt.executeUpdate() == 1){
                //정상 수행
                flag = 0;
            }
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }

        return flag;
    }

    public ArrayList<BoardTO> boardList(){
        ArrayList<BoardTO> lists = new ArrayList<>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        StringBuilder sbHtml = new StringBuilder();

        try {
            conn = this.dataSource.getConnection();

            String sql = "select seq, subject, writer, wdate, hit, emot, datediff(now(), wdate) as wgap from emot_board1 order by seq desc";
            pstmt = conn.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );

            rs = pstmt.executeQuery();

            while ( rs.next() ) {
                BoardTO to = new BoardTO();

                to.setSeq(rs.getString( "seq" ));
                to.setSubject(rs.getString( "subject" ));
                to.setWriter(rs.getString( "writer" ));
                to.setWdate(rs.getString( "wdate" ));
                to.setHit(rs.getString( "hit" ));
                to.setEmot(rs.getString( "emot" ));
                to.setWgap(rs.getInt("wgap"));

                lists.add( to );
            }
        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch (SQLException e) {}
            if( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
            if( conn != null ) try { conn.close(); } catch (SQLException e) {}
        }

        return lists;
    }

    public BoardTO boardView(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = this.dataSource.getConnection();

            String sql = "update emot_board1 set hit = hit + 1 where seq = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, to.getSeq());
            pstmt.executeUpdate();

            sql = "select subject, writer, mail, wip, wdate, hit, content, emot from emot_board1 where seq=?";
            pstmt = conn.prepareStatement( sql );
            pstmt.setString( 1, to.getSeq() );

            rs = pstmt.executeQuery();

            if ( rs.next() ) {
                to.setSubject(rs.getString( "subject" ));
                to.setWriter(rs.getString( "writer" ));
                to.setMail(rs.getString( "mail" ));
                to.setWip(rs.getString( "wip" ));
                to.setWdate(rs.getString( "wdate" ));
                to.setHit(rs.getString( "hit" ));
                to.setContent(rs.getString( "content" ));
                to.setEmot(rs.getString( "emot" ));
            }

        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch (SQLException e) {}
            if( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
            if( conn != null ) try { conn.close(); } catch (SQLException e) {}
        }

        return to;
    }

    public BoardTO boardDelete(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = this.dataSource.getConnection();

            String sql = "select subject, writer from emot_board1 where seq=?";
            pstmt = conn.prepareStatement( sql );
            pstmt.setString( 1, to.getSeq() );

            rs = pstmt.executeQuery();

            if ( rs.next() ) {
                to.setSubject(rs.getString( "subject" ));
                to.setWriter(rs.getString( "writer" ));
            }

        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch (SQLException e) {}
            if( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
            if( conn != null ) try { conn.close(); } catch (SQLException e) {}
        }

        return to;
    }

    public int boardDeleteOk(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;

        // 정상 : 0 / 비밀번호 오류 : 1 / 시스템 오류 : 2
        int flag = 2;

        try {
            conn = this.dataSource.getConnection();

            String sql = "delete from emot_board1 where seq = ? and password = md5(?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, to.getSeq());
            pstmt.setString(2, to.getPassword());

            int result = pstmt.executeUpdate();

            if (result == 0){
                //번호나 비밀번호 오류
                flag = 1;
            } else if (result == 1){
                // 정상
                flag = 0;
            }

        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
            if( conn != null ) try { conn.close(); } catch (SQLException e) {}
        }

        return flag;
    }

    public BoardTO boardModify(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = this.dataSource.getConnection();

            String sql = "select subject, writer, mail, content, emot from emot_board1 where seq = ? ";
            pstmt = conn.prepareStatement( sql );
            pstmt.setString(1, to.getSeq());

            rs = pstmt.executeQuery();

            if(rs.next()){
                to.setSubject(rs.getString("subject"));
                to.setWriter(rs.getString("writer"));
                to.setMail(rs.getString("mail"));
                to.setContent(rs.getString("writer"));
            }

        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch (SQLException e) {}
            if( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
            if( conn != null ) try { conn.close(); } catch (SQLException e) {}
        }

        return to;
    }

    public int boardModifyOk(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;

        // 정상 : 0 / 비밀번호 오류 : 1 / 시스템 오류 : 2
        int flag = 2;

        try {
            conn = this.dataSource.getConnection();

            String sql = "update emot_board1 set subject = ?, mail = ?, content = ?, emot = ? where seq = ? and password = md5(?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, to.getSubject());
            pstmt.setString(2, to.getMail());
            pstmt.setString(3, to.getContent());
            pstmt.setString(4, to.getEmot());
            pstmt.setString(5, to.getSeq());
            pstmt.setString(6, to.getPassword());

            int result = pstmt.executeUpdate();

            if (result == 0){
                flag = 1; //번호나 비밀번호 오류
            } else if (result == 1){
                flag = 0; // 정상
            }
        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
            if( conn != null ) try { conn.close(); } catch (SQLException e) {}
        }

        return flag;
    }
}
