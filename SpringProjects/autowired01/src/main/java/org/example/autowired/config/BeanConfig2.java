package org.example.autowired.config;

import org.example.autowired.model2.BoardDAO;
import org.example.autowired.model2.WriteAction;
import org.springframework.context.annotation.Bean;

public class BeanConfig2 {
	@Bean
	public BoardDAO dao() {
		return new BoardDAO();
	}

	@Bean
	public WriteAction writeAction(BoardDAO dao) {
		return new WriteAction( dao );
	}
}
