package org.example.di.model;

public class HelloBean {
    public HelloBean() {
        System.out.println("HelloBean 생성자 호출");
    }

    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }
}
