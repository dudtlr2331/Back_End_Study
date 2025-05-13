package com.example.pds.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class BoardDAO {

	@Autowired
	private DataSource dataSource;

	public void boardWrite() {
	}

	public int boardWriteOk( BoardTO to ) {
		System.out.println( "boardWriteOk() 호출" );

		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 1;

		try {
			conn = this.dataSource.getConnection();

			String sql = "insert into pds_board1 values ( 0, ?, ?, ?, md5( ? ), ?, ?, ?, 0, ?, now() )";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSubject() );
			pstmt.setString( 2, to.getWriter() );
			pstmt.setString( 3, to.getMail() );
			pstmt.setString( 4, to.getPassword() );
			pstmt.setString( 5, to.getContent() );
			pstmt.setString( 6, to.getFileName() );
			pstmt.setInt( 7, to.getFileSize() );
			pstmt.setString( 8, to.getWip() );

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

	public ArrayList<BoardTO> boardList() {
		System.out.println( "boardList() 호출" );

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BoardTO> lists = new ArrayList<>();

		try {
			conn = this.dataSource.getConnection();

			String sql = "select seq, subject, writer, filename, wdate, hit, datediff( now(), wdate ) wgap from pds_board1 order by seq desc";
			pstmt = conn.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );

			rs = pstmt.executeQuery();

			while ( rs.next() ) {
				BoardTO to = new BoardTO();
				to.setSeq( rs.getString( "seq" ) );
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setFileName( rs.getString( "filename" ) );
				to.setWdate( rs.getString( "wdate" ) );
				to.setHit( rs.getString( "hit" ) );
				to.setWgap( rs.getInt( "wgap" ) );

				lists.add( to );
			}
		} catch ( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch ( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
		}

		return lists;
	}

	public BoardTO boardView( BoardTO to ) {
		System.out.println( "boardView() 호출" );

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.dataSource.getConnection();

			String sql = "update pds_board1 set hit=hit+1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );

			pstmt.executeUpdate();

			sql = "select subject, writer, mail, wip, wdate, hit, content, filename, filesize from pds_board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );

			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setMail( rs.getString( "mail" ) );
				to.setWip( rs.getString( "wip" ) );
				to.setWdate( rs.getString( "wdate" ) );
				to.setHit( rs.getString( "hit" ) );
				to.setContent( rs.getString( "content" ) );
				to.setFileName( rs.getString( "filename" ) );
				to.setFileSize( rs.getInt( "filesize" ) );
			}
		} catch ( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch ( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
		}
		return to;
	}

	public BoardTO boardDelete( BoardTO to ) {
		System.out.println( "boardDelete() 호출" );

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.dataSource.getConnection();

			String sql = "select subject, writer from pds_board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );

			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
			}
		} catch ( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch ( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
		}
		return to;
	}

	public int boardDeleteOk( BoardTO to ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;

		try {
			conn = this.dataSource.getConnection();

			String sql = "select filename from pds_board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );

			rs = pstmt.executeQuery();

			String fileName = "";
			if ( rs.next() ) {
				fileName = rs.getString( "filename" );
			}

			sql = "delete from pds_board1 where seq=? and password = md5( ? )";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			pstmt.setString( 2, to.getPassword() );

			int result = pstmt.executeUpdate();
			if ( result == 0 ) {
				flag = 1;
			} else if ( result == 1 ) {
				flag = 0;

				if ( !fileName.equals( "" ) ) {
					new File("c:/java/upload", fileName).delete();
				}
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch ( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
		}
		return flag;
	}

	public BoardTO boardModify( BoardTO to ) {
		System.out.println( "boardModify() 호출" );

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.dataSource.getConnection();

			String sql = "select subject, writer, mail, content, filename from pds_board1 where seq = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );

			rs = pstmt.executeQuery();

			if ( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setMail( rs.getString( "mail" ) );
				to.setContent( rs.getString( "content" ) );
				to.setFileName( rs.getString( "filename" ) );
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch ( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
		}
		return to;
	}

	public int boardModifyOk( BoardTO to ) {
		System.out.println( "boardModifyOk() 호출" );

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;

		try {
			conn = this.dataSource.getConnection();

			// 기존 파일명 가져오기
			String sql = "select filename from pds_board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );

			rs = pstmt.executeQuery();

			String fileName = "";
			if ( rs.next() ) {
				fileName = rs.getString( "filename" );
			}

			// 첨부 파일 있는 경우
			// 첨부 파일 없는 경우

			if ( to.getFileName().equals("") ) {
				sql = "update pds_board1 set subject=?, mail=?, content=? where seq=? and password=md5(?)";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, to.getSubject() );
				pstmt.setString( 2, to.getMail() );
				pstmt.setString( 3, to.getContent() );
				pstmt.setString( 4, to.getSeq() );
				pstmt.setString( 5, to.getPassword() );
			} else {
				sql = "update pds_board1 set subject=?, mail=?, content=?, filename=?, filesize=? where seq=? and password=md5(?)";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, to.getSubject() );
				pstmt.setString( 2, to.getMail() );
				pstmt.setString( 3, to.getContent() );
				pstmt.setString( 4, to.getFileName() );
				pstmt.setInt( 5, to.getFileSize() );
				pstmt.setString( 6, to.getSeq() );
				pstmt.setString( 7, to.getPassword() );
			}

			int result = pstmt.executeUpdate();
			if ( result == 0 ) {
				flag = 1;
			} else if ( result == 1 ) {
				flag = 0;

				if( !fileName.equals("") && !to.getFileName().equals("") ) {
					new File( "c:/java/upload",  fileName ).delete();
				}
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch ( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch ( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch ( SQLException e ) {}
		}
		return flag;
	}
}
