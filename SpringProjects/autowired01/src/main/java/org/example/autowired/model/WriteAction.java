package org.example.autowired.model;

import org.springframework.beans.factory.annotation.Autowired;

public class WriteAction {

	// 필드 의존성 자동 주입
	@Autowired
	private BoardDAO dao;

	public WriteAction() {
		System.out.println( "WriteAction() 호출" );
		System.out.println( "1. dao : " + dao );
	}

	public void viewDao() {
		System.out.println( "2. dao : " + dao );
	}
}
