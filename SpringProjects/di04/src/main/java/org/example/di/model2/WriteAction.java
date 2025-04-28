package org.example.di.model2;

public class WriteAction {
	private BoardTO to;

	// 디폴트 생성
	public WriteAction() {
		System.out.println( "WriteAction() 호출" );
		this.to = new BoardTO();
	}

	// BoardTO를 생성
	public WriteAction(BoardTO to) {
		System.out.println( "WriteAction(BoardTO to) 호출" );
		this.to = to;
	}

	public void execute() {
		System.out.println( "execute() 호출 : " + to );
	}
}
