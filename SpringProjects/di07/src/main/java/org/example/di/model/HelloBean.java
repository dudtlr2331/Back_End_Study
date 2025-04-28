package org.example.di.model;

public class HelloBean {
    public HelloBean() {
        System.out.println("HelloBean() 호출");
    }

    public void sayHello(String name) {
        System.out.println(name + "님 안녕하세요.");
    }
}
