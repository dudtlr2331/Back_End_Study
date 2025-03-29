interface I{
}

abstract class E {
    public abstract void salary();
}

class Class1 extends E {

    @Override
    public void salary() {
        // TODO Auto-generated method stub
        System.out.println("Class2 salary");    
    }
    
}

class Class2 extends E {

    @Override
    public void salary() {
        // TODO Auto-generated method stub
        System.out.println("Class2 salary");    
    }
    
}

public class InstanceOfEx01 {
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();

        E e1 = new Class1();
        E e2 = new Class2();

        System.out.println(e1 instanceof Class1);
        System.out.println(e2 instanceof Class2);

        System.out.println(e1 instanceof Class2);

        System.out.println(e1 instanceof E);
        System.out.println(e2 instanceof E);
        System.out.println(e2 instanceof Object);
    }
}
