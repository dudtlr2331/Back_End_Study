package org.example.autowired.model2;

import org.example.autowired.model1.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "writeAction")
public class WriteAction {

//    @Autowired
    private BoardDAO dao;

    public WriteAction() {
        System.out.println("WriteAction() 호출");
        System.out.println("1. dao : " + dao);
    }

//    @Autowired
//    public WriteAction(BoardDAO dao) {
//        this.dao = dao;
//        System.out.println("WriteAction(BoardDAO dao) 호출");
//        System.out.println("1. dao : " + dao);
//    }

    @Autowired
    public void setDao(BoardDAO dao) {
        this.dao = dao;
    }

    public void viewDao() {
        System.out.println("2. dao : " + dao);
    }
}
