package org.example.di.model2;

public class WriteAction {
    private BoardTO to;

    public WriteAction() {
        System.out.println("WriteAction() 호출");
        this.to = new BoardTO();
    }

    // 생성자 주입 = 사용자 클래스 통해서 주입
    public WriteAction(BoardTO to) {
        System.out.println("WriteAction(BoardTO to) 호출");
        this.to = to;
    }

    public void excute(){
        System.out.println("Hello " + to);
    }
}
