class Person1{
    String name;
    int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("이름 : " + this.name + ", 나이 : " + this.age);
    }
}

class Student2 extends Person1{
    String school;

    public Student2(String school, String name, int age) {
        super(name, age);
        this.school = school;
    }

    @Override
    public void introduce() {
//        super.introduce();
        System.out.println("이름 : " + this.name + ", 나이 : " + this.age + ",학교 : " + school);
    }
}

public class TestApp3{
    public static void main(String[] args) {
        Person1 p1 = new Person1("이름", 20);
        Student2 s1 = new Student2("학교명", "이름", 10);

        p1.introduce();
        s1.introduce();
    }
}
