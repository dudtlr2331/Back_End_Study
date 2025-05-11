package org.example.board.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository
public class BoardDAO2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int boardWriteOk(BoardTO to){
        String sql = "insert into board1 values ( 0, ?, ?, ?, md5( ? ), ?, 0, ?, now() )";

        int flag = 1;

        try {
            int result = jdbcTemplate.update( sql,
                    to.getSubject(),
                    to.getWriter(),
                    to.getMail(),
                    to.getPassword(),
                    to.getContent(),
                    to.getWip()
            );

            if (result == 1) {
                flag = 0;
            }
        } catch (Exception e) {
            System.out.println("[에러] " + e.getMessage());
        }

        return flag;
    }

    public ArrayList<BoardTO> boardList(){
        String sql = "select seq, subject, writer, wdate, hit, datediff(now(), wdate) as wgap from board1 order by seq desc";
        ArrayList<BoardTO> lists = (ArrayList<BoardTO>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardTO.class));

        return lists;
    }

    public BoardTO boardView(BoardTO to){
        String sql = "update board1 set hit = hit + 1 where seq = ?";
        jdbcTemplate.update(sql, to.getSeq());

        sql = "select seq, subject, writer, mail, wip, wdate, hit, content from board1 where seq=?";
        to = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardTO.class), to.getSeq());

        return to;
    }

    public BoardTO boardDelete(BoardTO to){
        to = (BoardTO) jdbcTemplate.queryForObject("select subject, writer, seq from board1 where seq=?", new BeanPropertyRowMapper<>(BoardTO.class), to.getSeq());

        return to;
    }

    public int boardDeleteOk(BoardTO to){
        int flag = 2;

        try {
            int result = jdbcTemplate.update(
                    "delete from board1 where seq = ? and password = md5(?)",
                    to.getSeq(),
                    to.getPassword()
            );

            if (result == 0) {
                flag = 1; // 비밀번호 틀림 or 존재하지 않는 seq
            } else if (result == 1) {
                flag = 0; // 삭제 성공
            }

        } catch (Exception e) {
            System.out.println("[에러] " + e.getMessage());
            flag = 2;
        }

        return flag;
    }

    public BoardTO boardModify(BoardTO to){
        to = jdbcTemplate.queryForObject(
                "select subject, writer, mail, content, seq from board1 where seq = ?",
                new BeanPropertyRowMapper<>(BoardTO.class),
                to.getSeq()
        );

        return to;
    }

    public int boardModifyOk(BoardTO to){
        int flag = 2;

        try {
            int result = jdbcTemplate.update(
                    "update board1 set subject = ?, mail = ?, content = ? where seq = ? and password = md5(?)",
                    to.getSubject(),
                    to.getMail(),
                    to.getContent(),
                    to.getSeq(),
                    to.getPassword()
            );

            if (result == 0) {
                flag = 1; // 비밀번호 오류 또는 해당 seq 없음
            } else if (result == 1) {
                flag = 0; // 정상 처리
            }

        } catch (Exception e) {
            System.out.println("[에러] " + e.getMessage());
            flag = 2; // 시스템 오류
        }

        return flag;
    }
}
