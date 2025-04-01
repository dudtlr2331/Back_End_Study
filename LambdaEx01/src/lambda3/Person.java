package lambda3;

import lambda3.Calcuable;

public class Person {
    public void action(Calcuable calcuable){
        double result = calcuable.clac(10, 4);
        System.out.println("결과 : " + result);
    }
}
