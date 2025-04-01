package lambda3;

public class MethodReferenceEx01 {
    public static void main(String[] args) {
        Person person = new Person();

        //다형성
        person.action(Math :: max);
        person.action(Computer :: staticCalc);

        Computer computer = new Computer();
        person.action((double x, double y) -> computer.instancCalc(x, y));
        person.action(computer :: instancCalc);
    }
}