package org.example.di.model2;

public class HelloBean2 implements Hello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }
}
