interface InterA {
    // 상수
    // 추상 메서드 선언
    public abstract void methodA();
    void methodB();
}
class ClassA implements InterA {
    public void methodA() {
        System.out.println( "methodA 실행" );
    }
    public void methodB() {
        System.out.println( "methodB 실행" );
    }
}
abstract class ClassB implements InterA {
    public void methodA() {
        System.out.println( "methodA 실행" );
    }
    // methodB
}
class ClassC extends ClassB {
    public void methodB() {
        System.out.println( "methodB 실행" );
    }
}
public class InterfaceEx01 {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        a.methodA();
        a.methodB();
        //ClassB b = new ClassB();
        ClassC c = new ClassC();
        c.methodA();
        c.methodB();
    }
}