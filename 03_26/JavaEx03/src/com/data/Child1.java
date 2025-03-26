package com.data;

public class Child1 extends Parent {
    public Child1() {
        System.out.println("Hello Child1");
    }

    @Override
    public void viewParent() {
        System.out.println("Child viewParent 호출");
    }
}
