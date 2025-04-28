package org.example.di.model3;

public class ListAction {
	private BoardTO to;

	public ListAction(BoardTO to) {
		System.out.println( "ListAction() 호출" );
		this.to = to;
	}

	public void execute() {
		System.out.println( to.getSeq() );
		System.out.println( to.getSubject() );
	}
}

