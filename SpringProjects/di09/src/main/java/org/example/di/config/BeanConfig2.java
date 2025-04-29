package org.example.di.config;

import org.example.di.model2.BoardListTO;
import org.example.di.model2.BoardTO;
import org.example.di.model2.WriteAction;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class BeanConfig2 {

    @Bean
    public WriteAction writeAction() {
        BoardTO to = new  BoardTO();
        to.setSeq("2");
        to.setSubject("제목2");

        WriteAction action = new WriteAction();
        action.setTo(to);

        return action;
    }

    @Bean
    public BoardListTO listTO1() {
        BoardListTO listTO = new BoardListTO();

        ArrayList<String> userLists = new ArrayList<>();
        userLists.add("홍길동");
        userLists.add("장길산");

        listTO.setUserLists(userLists);

        BoardTO to1 = new BoardTO();
        to1.setSeq("1");
        to1.setSubject("제목1");

        BoardTO to2 = new BoardTO();
        to2.setSeq("2");
        to2.setSubject("제목2");

        ArrayList<BoardTO> boardLists = new ArrayList<>();
        boardLists.add(to1);
        boardLists.add(to2);

        listTO.setBoardList(boardLists);

        return listTO;
    }
}
