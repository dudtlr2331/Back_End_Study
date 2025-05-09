package org.example.pagingmodel1;

import java.util.ArrayList;

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

    public int getCpage() {
        return cpage;
    }

    public void setCpage(int cpage) {
        this.cpage = cpage;
    }

    public int getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(int recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    public int getPagePerBlock() {
        return pagePerBlock;
    }

    public void setPagePerBlock(int pagePerBlock) {
        this.pagePerBlock = pagePerBlock;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartBlock() {
        return startBlock;
    }

    public void setStartBlock(int startBlock) {
        this.startBlock = startBlock;
    }

    public int getEndBlock() {
        return endBlock;
    }

    public void setEndBlock(int endBlock) {
        this.endBlock = endBlock;
    }

    public ArrayList<BoardTO> getBoardLists() {
        return boardLists;
    }

    public void setBoardLists(ArrayList<BoardTO> boardLists) {
        this.boardLists = boardLists;
    }
}
