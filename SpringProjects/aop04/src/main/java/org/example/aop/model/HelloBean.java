package org.example.aop.model;

import org.springframework.stereotype.Service;

@Service(value = "target")
public class HelloBean implements Hello {

    public HelloBean() {
        System.out.println("HelloBean() 호출");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
