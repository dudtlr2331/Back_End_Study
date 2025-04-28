package lambda4;

public class MethodReferenceEx01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.ordering(String :: compareToIgnoreCase);
    }
}
