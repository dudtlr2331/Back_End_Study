package org.example.di.config;

import org.example.di.model2.BoardTO;
import org.example.di.model2.WriteAction;
import org.springframework.context.annotation.Bean;

public class BeanConfig2 {

    @Bean
    public WriteAction writeAction1(){
        return new WriteAction();
    }

    @Bean
    public WriteAction writeAction2(){
        return new WriteAction(new BoardTO());
    }

    public BoardTO boardTO(){
        System.out.println("boardTO() 호출");
        return new BoardTO();
    }

    @Bean
    public WriteAction writeAction31(){
        return new WriteAction(boardTO());
    }

    @Bean
    public WriteAction writeAction32(){
        return new WriteAction(boardTO());
    }
}
