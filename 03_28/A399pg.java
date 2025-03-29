class A {
    class B{
        int field1 = 1;

        static int field2 = 2;

        B(){
            System.out.println("B-생성자 실행");
        }
        
        void method1(){
            System.out.println("B-메소드1 실행");
        }

        static void method2(){
            System.out.println("B-메소드2 실행");
        }
    }

    void useB(){
        B b = new B();
        System.out.println(b.field1);
        b.method1();

        System.out.println(B.field2);
        b.method2();
    }
}

public class A399pg {
    public static void main(String[] args) {
        A a = new A();

        a.useB();
    }
}
