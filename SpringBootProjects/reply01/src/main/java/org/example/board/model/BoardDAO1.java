package org.example.board.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class BoardDAO1 {

    @Autowired
    private DataSource dataSource;

    public int boardWriteOk(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;

        int flag = 1;

        try {
            conn = this.dataSource.getConnection();

            String sql = "insert into rep_board1 values(0, last_insert_id()+1, 0, 0, ?, ?, ?, md5(?), ?, 0, ?, now());";
            pstmt = conn.prepareStatement( sql );
            pstmt.setString( 1, to.getSubject() );
            pstmt.setString( 2, to.getWriter() );
            pstmt.setString( 3, to.getMail() );
            pstmt.setString( 4, to.getPassword() );
            pstmt.setString( 5, to.getContent() );
            pstmt.setString( 6, to.getWip() );

            if ( pstmt.executeUpdate() == 1 ) {
                flag = 0;
            }
        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
            if ( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
        }

        return flag;
    }

    public BoardListTO boardList(BoardListTO listTO) {
        System.out.println( "boardList() 호출" );

        int cpage = listTO.getCpage();
        int recordPerPage = listTO.getRecordPerPage();
        int pagePerBlock = listTO.getPagePerBlock();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = this.dataSource.getConnection();

            String sql = "select seq, grpl, subject, writer, wdate, hit, datediff(now(), wdate) as wgap from rep_board1 order by grp desc, grps asc";
            pstmt = conn.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );

            rs = pstmt.executeQuery();

            rs.last();
            listTO.setTotalRecord( rs.getRow() );
            rs.beforeFirst();

            listTO.setTotalPage( ( ( listTO.getTotalRecord() - 1 ) / recordPerPage ) + 1 );

            int skip = (cpage - 1) * recordPerPage;
            if( skip != 0 ) rs.absolute( skip );

            ArrayList<BoardTO> boardLists = new ArrayList<>();
            for( int i=0 ; i<recordPerPage && rs.next() ; i++ ) {
                BoardTO to = new BoardTO();

                to.setSeq( rs.getString( "seq" ) );
                to.setGrpl(rs.getInt("grpl"));
                to.setSubject( rs.getString( "subject" ) );
                to.setWriter( rs.getString( "writer" ) );
                to.setWdate( rs.getString( "wdate" ) );
                to.setHit( rs.getString( "hit" ) );
                to.setWgap( rs.getInt( "wgap" ) );

                boardLists.add( to );
            }

            listTO.setBoardLists( boardLists );

            listTO.setStartBlock( cpage - ( cpage - 1 ) % pagePerBlock );
            listTO.setEndBlock( cpage - ( cpage - 1 ) % pagePerBlock + pagePerBlock - 1 );
            if( listTO.getEndBlock() >= listTO.getTotalPage() ) {
                listTO.setEndBlock( listTO.getTotalPage() );
            }
        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if( rs != null ) try { rs.close(); } catch ( SQLException e ) {}
            if( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
            if( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
        }

        return listTO;
    }


    public BoardTO boardView(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = this.dataSource.getConnection();

            // 조회수 증가
            String sql = "update rep_board1 set hit = hit + 1 where seq = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, to.getSeq());
            pstmt.executeUpdate();

            sql = "select subject, writer, mail, wip, wdate, hit, content from rep_board1 where seq=?";
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

            String sql = "select subject, writer from rep_board1 where seq=?";
            pstmt = conn.prepareStatement(sql);
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

        int flag = 2;

        try {
            conn = this.dataSource.getConnection();

            String sql = "delete from rep_board1 where seq = ? and password = md5(?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, to.getSeq());
            pstmt.setString(2, to.getPassword());

            int result = pstmt.executeUpdate();
            if (result == 0){
                flag = 1;
            } else if (result == 1){
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

            String sql = "select subject, writer, mail, content from rep_board1 where seq = ? ";
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

            String sql = "update rep_board1 set subject = ?, mail = ?, content = ? where seq = ? and password = md5(?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, to.getSubject());
            pstmt.setString(2, to.getMail());
            pstmt.setString(3, to.getContent());
            pstmt.setString(4, to.getSeq());
            pstmt.setString(5, to.getPassword());

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

    public int boardReplyOk(BoardTO to){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int flag = 1;

        try {
            conn = this.dataSource.getConnection();

            // 부모글에 대한 정보(grp, grps, grpl)
            String sql = "select grp, grps, grpl from rep_board1 where seq = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, to.getSeq());

            rs = pstmt.executeQuery();

            int grp = 0;
            int grps = 0;
            int grpl = 0;

            if(rs.next()){
                grp = rs.getInt("grp");
                grps = rs.getInt("grps");
                grpl = rs.getInt("grpl");
            }

            // grps 업데이트
            sql = "update rep_board1 set grps=grps+1 where grp = ? and grp > ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, grp);
            pstmt.setInt(2, grps);

            pstmt.executeUpdate();


            sql = "insert into rep_board1 values(0, ?, ?, ?, ?, ?, ?, md5(?), ?, 0, ?, now());";
            pstmt = conn.prepareStatement( sql );

            pstmt.setInt( 1, grp );
            pstmt.setInt( 2, grps + 1);
            pstmt.setInt( 3, grpl + 1);
            pstmt.setString( 4, to.getSubject() );
            pstmt.setString( 5, to.getWriter() );
            pstmt.setString( 6, to.getMail() );
            pstmt.setString( 7, to.getPassword() );
            pstmt.setString( 8, to.getContent() );
            pstmt.setString( 9, to.getWip() );

            if ( pstmt.executeUpdate() == 1 ) {
                flag = 0;
            }
        } catch ( SQLException e ) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
            if ( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
        }

        return flag;
    }
}
