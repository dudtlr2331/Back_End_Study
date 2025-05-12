package org.example.board.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BoardListTO {
    // 페이지 디자인
    private int cpage;
    private int recordPerPage;
    private int pagePerBlock;
    private int totalPage;
    private int totalRecord;
    private int startBlock;
    private int endBlock;

    // 게시판 데이터
    private ArrayList<BoardTO> boardLists;

    public BoardListTO() {
        this.recordPerPage = 10;
        this.pagePerBlock = 5;
    }
}
