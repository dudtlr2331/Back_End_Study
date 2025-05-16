package instancof;
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("이름 : " + this.name + ", 나이 : " + this.age);
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
        System.out.println("이름 : " + this.name + ", 나이 : " + this.age + ", 학교 : " + this.school);
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
        System.out.println("이름 : " + this.name + ", 나이 : " + this.age + ", 과목 : " + this.subject);

    }
}

public class TestApp3{
    public static void main(String[] args) {
        Person[] persons = {
                new Student("홍길동", 19, "땡땡고등학교"),
                new Teacher("김선생", 30, "수학")
        };

        for (Person person : persons) {
            if(person instanceof Student){
                System.out.println("이 사람은 학생입니다.");
            }else if (person instanceof Teacher){
                System.out.println("이 사람은 선생님입니다.");
            }

            person.introduce();
        }

    }
}
