package instancof;

class Person1{
    String name;
    int age;

    // 기본생성자는 자동으로 호출 해주는데
    // 매개변수가 있는 생성자는 자식 클래스 생성자에서 부모 클래스 생성자를 호출해줘야한다.

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void introduce() {
        System.out.println("이름 : " + this.name + ", 나이 : " + this.age);
    }
}

class Studnet1 extends Person1{
    String school;

    public Studnet1(String name, int age, String school) {
        super(age, name);
        this.school = school;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("학교 : " + this.school);
    }
}

class Teacher1 extends Person1{
    String subject;

    public Teacher1(int age, String name, String subject) {
        super(age, name);
        this.subject = subject;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("과목 : " + this.subject);
    }
}

public class TestApp {
    public static void main(String[] args) {
//        Studnet1 s1 = new Studnet1( "홍길동", 19, "땡땡고등학교");
//        Teacher1 t1 = new Teacher1(10, "이름", "수학");

        Person1[] person = {
                new Studnet1( "홍길동", 19, "땡땡고등학교"),
                new Teacher1(10, "이름", "수학")
        };

        int[] a = { 1, 2, 3 };

//        s1.introduce();
//        t1.introduce();


        person[0].introduce();
        person[1].introduce();

        for (Person1 persons : person) {

            if(persons instanceof Studnet1){
                System.out.println("이 사람은 학생입니다.");
            }else if(persons instanceof Teacher1){
                System.out.println("이 사람은 선생님입니다.");
            }

            persons.introduce();
        }

    }
}
