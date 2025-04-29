package org.example.di.model2;

import java.util.ArrayList;

public class BoardListTO {
    private ArrayList<String> userLists;
    private ArrayList<BoardTO> boardList;

    public ArrayList<String> getUserLists() {
        return userLists;
    }

    public void setUserLists(ArrayList<String> userLists) {
        this.userLists = userLists;
    }

    public ArrayList<BoardTO> getBoardList() {
        return boardList;
    }

    public void setBoardList(ArrayList<BoardTO> boardList) {
        this.boardList = boardList;
    }
}
