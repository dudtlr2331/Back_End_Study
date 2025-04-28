package org.example.di.model1;

public class HelloBean2 implements Hello {

    public HelloBean2() {
        System.out.println("HelloBean2() 호출");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
