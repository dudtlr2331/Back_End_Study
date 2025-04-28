package model2;

public class HelloBean2 implements Hello {
    @Override
    public void sayHello(String name) {
        System.out.println("HelloBean2 " + name);
    }
}
