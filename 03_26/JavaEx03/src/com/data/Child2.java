package com.data;

public class Child2 extends Parent {
    public Child2() {
        System.out.println("Hello Child2");
    }

    @Override
    public void viewParent() {
        System.out.println("Child2 viewParent호출");
    }
}
