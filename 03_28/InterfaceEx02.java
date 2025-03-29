interface InterA{
    void methodA();
}

interface InterB{
    void methodB();
}

class ClassA implements InterA, InterB{

    @Override
    public void methodB() {
        System.out.println("메소드 B 호출");
    }

    @Override
    public void methodA() {
        System.out.println("메소드 A 호출");
    }
    
}

public class InterfaceEx02 {
    ClassA a = new ClassA();
    // a.methodA();
    
}
