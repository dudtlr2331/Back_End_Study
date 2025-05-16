class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("이름 : " + this.name);
        System.out.println("나이 : " + this.age);
    }
}

class Student extends Person {
    String school;

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("학교 : " + this.school);
    }
}

public class TestApp2 {
    public static void main(String[] args) {
        Person person = new Person("홍길동", 20);
        person.introduce();

        Student student = new Student("김땡땡", 18, "서울고등학교");
        student.introduce();

        Person[] people = new Person[2];
        people[0] = new Person("홍길동", 40);
        people[1] = new Student("김영희", 20, "서울대학교");

        for (Person p : people) {
            p.introduce();
        }
    }
}
