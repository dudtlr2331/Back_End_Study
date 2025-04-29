package org.example.autowired.config;

import org.example.autowired.model.BoardDAO;
import org.example.autowired.model.WriteAction;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

	@Bean
	public BoardDAO dao1() {
		BoardDAO dao = new BoardDAO();
		System.out.println( "dao : " + dao );
		return dao;
	}

	@Bean
	public WriteAction writeAction() {
		return new WriteAction();
	}
}
