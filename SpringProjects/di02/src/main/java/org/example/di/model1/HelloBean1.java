package org.example.di.model1;

public class HelloBean1 {

    public HelloBean1() {
        System.out.println("HelloBean1();");
    }

    public void sayHello(String name) {
        System.out.println(name + "님 안녕하세요.");
    }
}
