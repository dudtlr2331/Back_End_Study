package org.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.board.dto.BoardTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardTO> list();
    int write_ok(BoardTO to);
    void view_hit(BoardTO to);
    BoardTO view(BoardTO to);
    BoardTO delete(BoardTO to);
    int delete_ok(BoardTO to);
    BoardTO modify(BoardTO to);
    int modify_ok(BoardTO to);
}