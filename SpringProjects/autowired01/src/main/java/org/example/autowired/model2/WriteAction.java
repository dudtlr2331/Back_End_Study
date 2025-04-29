package org.example.autowired.model2;

import org.springframework.beans.factory.annotation.Autowired;

public class WriteAction {
	private BoardDAO dao;

	// 생성자
	public WriteAction(BoardDAO dao) {
		this.dao = dao;
		System.out.println( "WriteAction(BoardDAO dao) 호출" );
		System.out.println( "1. dao : " + dao );
	}

	public void viewDao() {
		System.out.println( "2. dao : " + dao );
	}
}
