interface Employee{
    //급여
    void salary();
}

class Employee1 implements Employee{
    @Override
    public void salary() {
        // TODO Auto-generated method stub
        System.out.println("Employee1 급여 출력");
    }
}

class Employee2 implements Employee{
    @Override
    public void salary() {
        // TODO Auto-generated method stub
        System.out.println("Employee2 급여 출력");
    }
}

public class PolyEx01 {
    public static void main(String[] args) {
        Employee1 e1 = new Employee1();
        e1.salary();
        Employee2 e2 = new Employee2();
        e2.salary();

        //다형성
        //부모를 이용해서 자식 내용 호출
        Employee e = new Employee1();
        e.salary();
        e = new Employee2();
        e.salary();
    }
}
