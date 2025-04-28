package object1;

public class ObjectEx03 {
    public static void main(String[] args) {
//        int a1 = 10;
//        int a2 = 20;
        
        //값에 대한 비교
//        System.out.println(a1 == a2);

        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println(o1);
        System.out.println(o2);
        //주소를 비교
        System.out.println(o1 == o2);

        // 멤버필드 값을 비교
        System.out.println(o1.equals(o2));

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // 주소를 비교
        System.out.println(s1 == s2); //false
        // 멤버필드 값을 비교
        System.out.println(s1.equals(s2)); //true

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
