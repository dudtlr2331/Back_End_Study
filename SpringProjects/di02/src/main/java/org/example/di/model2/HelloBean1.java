package org.example.di.model2;

public class HelloBean1 implements Hello {
    @Override
    public void sayHello(String name) {
        System.out.println(name + "님 안녕하세요.");
    }
}
