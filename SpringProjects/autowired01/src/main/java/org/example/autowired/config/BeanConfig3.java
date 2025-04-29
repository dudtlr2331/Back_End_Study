package org.example.autowired.config;

import org.example.autowired.model3.BoardDAO;
import org.example.autowired.model3.WriteAction;
import org.springframework.context.annotation.Bean;

public class BeanConfig3 {
	@Bean
	public BoardDAO dao() {
		return new BoardDAO();
	}

	@Bean
	public WriteAction writeAction() {
		BoardDAO dao = null;
		WriteAction action = new WriteAction();
		action.setDao(dao);
		return action;
	}
}
