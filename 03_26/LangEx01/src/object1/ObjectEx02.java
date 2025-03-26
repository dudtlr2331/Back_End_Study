package object1;

public class ObjectEx02 {
    public static void main(String[] args) {
        String s = new String("Hello");
        System.out.println(s);
        System.out.println(s.toString());

        Person p = new Person("John", 25);
        System.out.println(p.toString());
    }
}
