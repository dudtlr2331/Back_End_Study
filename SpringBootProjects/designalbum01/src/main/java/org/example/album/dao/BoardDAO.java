package org.example.album.dao;

import org.example.album.dto.BoardTO;
import org.example.album.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    private BoardMapper boardMapper;

    public int boardWriteOk(BoardTO to) {
        int flag = 1;
        int result = boardMapper.write_ok(to);

        if(result == 1) {
            flag = 0;
        }

        return flag;
    }

    public List<BoardTO> boardList() {
        return boardMapper.list();
    }

    public BoardTO boardView(BoardTO to) {
        boardMapper.view_hit(to);
        return boardMapper.view(to);
    }

    public BoardTO boardDelete(BoardTO to) {
        return boardMapper.delete(to);
    }

    public int boardDeleteOk(BoardTO to) {
        int flag = 1;
        int result = boardMapper.delete_ok(to);

        if(result == 1) {
            flag = 0;
        }else {
            flag = 2;
        }

        return flag;
    }

    public BoardTO boardModify(BoardTO to) {
        return boardMapper.modify(to);
    }

    public int boardModifyOk(BoardTO to) {
        int flag = 2;
        int result = boardMapper.modify_ok(to);

        if(result == 1) {
            flag = 0;
        } else if (result == 0) {
            flag = 1;
        }

        return flag;
    }
}
