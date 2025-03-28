package math1;

public class MathEx01 {
    public static void main(String[] args) {
        //올림
        System.out.println(Math.ceil(10.3));
        System.out.println(Math.ceil(10.5));
        System.out.println(Math.ceil(10.7));

        //내림
        System.out.println(Math.floor(10.3));
        System.out.println(Math.floor(10.5));
        System.out.println(Math.floor(10.7));

        //반올림
        System.out.println(Math.round(10.3));
        System.out.println(Math.round(10.5));
        System.out.println(Math.round(10.7));

//        지수
        System.out.println(Math.pow(10, 3));

        //최대, 최소
        System.out.println(Math.max(10, 3));
        System.out.println(Math.min(10, 3));
    }
}
