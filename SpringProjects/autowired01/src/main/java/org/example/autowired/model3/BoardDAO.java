package org.example.autowired.model3;

import org.springframework.stereotype.Service;

@Service
public class BoardDAO {

	public BoardDAO() {
		System.out.println( "BoardDAO() 호출" );
	}
}
