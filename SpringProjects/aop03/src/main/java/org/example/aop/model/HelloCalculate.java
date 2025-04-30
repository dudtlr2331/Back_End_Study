package org.example.aop.model;

import org.springframework.stereotype.Service;

@Service("target")
public class HelloCalculate implements Calculate {

    public HelloCalculate() {
        System.out.println("HelloCalculate() 호출");
    }

    @Override
    public void doCalculate() {
        int sum = 0;

        for(int i = 0; i < 1_000_000; i++) {
            sum += i;
        }

        System.out.println("결과 : " + sum);
    }
}
