package org.example.aop.model;

import lombok.Setter;

@Setter
public class WriteAction implements Action {
    private String writer;

    public WriteAction() {
        System.out.println("WriteAction() 호출");
    }

    // Cor concern
    @Override
    public void execute() {
        System.out.println("execute() 시작");

        int data = 0;
        for(int i = 1; i <= 1_000_000; i++) {
            data += i;
        }

        System.out.println("Hello " + writer);
        System.out.println("execute() 끝");
    }

    @Override
    public void execute1() {
        System.out.println("execute() 시작");
        System.out.println("Hello " + writer);
        System.out.println("execute() 끝");
    }

    @Override
    public void execute2() {
        System.out.println("execute() 시작");
        System.out.println("Hello " + writer);
        System.out.println("execute() 끝");
    }
}
