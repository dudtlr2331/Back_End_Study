package org.example.di.config;

import org.example.di.modle1.BoardTO;
import org.example.di.model2.WriteAction;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public BoardTO boardTO() {
        BoardTO boardTO = new BoardTO();
        boardTO.setSeq("1");
        boardTO.setSubject("제목1");

        return boardTO;
    }
}
