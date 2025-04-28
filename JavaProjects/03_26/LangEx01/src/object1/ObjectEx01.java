package object1;

public class ObjectEx01 {
    public static void main(String[] args) {
        //object 클래스 생성
        Object o = new Object();
//        java.lang.Object@41629346
//        패키지.클래스명@해시코드 : 참조주소
        System.out.println(o);
        System.out.println(o.toString());

        Person p = new Person("John", 25);
        System.out.println(p);
        System.out.println(p.toString());
    }
}
