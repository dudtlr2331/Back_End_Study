class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("이름 : " + name + ", 나이 : " + age);
    }
}

class Student extends Person{
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

class Teacher extends Person{
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("과목 : " + this.subject);
    }
}


public class TestApp2 {
    public static void main(String[] args) {
//        Person person = new Person("홍길동", 20);
//        Student student = new Student("김철수", 10 , "땡땡초등학교");

//        person.introduce();
//        student.introduce();

//        Person student1 = new Student("김영희", 10 , "서울초등학교");
//        student1.introduce();

//        Person[] persons = {
//                new Person("홍길동", 20) ,
//                new Student("김영희", 10 , "서울초등학교")
//        };

//        Person[] persons1 = {};
//        persons1[0] = student;
//        persons1[1] = student1;

        Person[] persons = {
                new Student( "홍길동", 19, "땡땡고등학교"),
                new Student( "김철수", 15, "땡땡중학교"),
                new Teacher("이름", 10, "수학"),
                new Teacher("이름", 20, "과학")
        };

        for (Person person : persons) {
            if(person instanceof Student) {
                person.introduce();
                System.out.println("학생입니다.");
            }else if(person instanceof Teacher) {
                person.introduce();
                System.out.println("선생님입니다.");
            }
        }
    }
}
