package org.example.di.model2;

public class WriteAction {
    public BoardTO to;

    public BoardTO getTo() {
        return to;
    }

    public void setTo(BoardTO to) {
        this.to = to;
    }

    public WriteAction() {
        System.out.println("Write Action() 호출");
    }

    public void execute() {
        System.out.println("to " +  to);
        System.out.println(to.getSeq());
        System.out.println(to.getSubject());
    }
}
