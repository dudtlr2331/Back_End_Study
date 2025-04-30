package org.example.aop.model;

import org.springframework.stereotype.Service;

@Service("target2")
public class HelloBean2 implements Hello {

    public HelloBean2() {
        System.out.println("HelloBean2() 호출");
    }

    @Override
    public void sayHello(String name) {
        System.out.println(name + " 님 안녕하세요" );
    }
}
