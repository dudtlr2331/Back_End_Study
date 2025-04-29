package org.example.autowired.model3;

import org.springframework.beans.factory.annotation.Autowired;

public class WriteAction {
    private BoardDAO dao;

    public WriteAction() {
        System.out.println("WriteAction() 호출");
        System.out.println("1. dao : " + dao);
    }

    //setter
    @Autowired
    public void setDao(BoardDAO dao) {
        this.dao = dao;
    }

    public void viewDao(){
        System.out.println("2. dao : " + dao);
    }
}
