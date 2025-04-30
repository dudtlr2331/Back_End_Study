package org.example.lombok.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HelloBean2 implements Hello {
    private String name;

    @Override
    public void sayHello() {
        System.out.println("Hello" + name);
    }
}
