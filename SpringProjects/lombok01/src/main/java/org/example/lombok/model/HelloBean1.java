package org.example.lombok.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HelloBean1 implements Hello {
    private String name;

    @Override
    public void sayHello() {
        System.out.println(name + "님 안녕하세요");
    }
}
