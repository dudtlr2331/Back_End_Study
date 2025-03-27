package math1;

public class MathEx02 {
    public static void main(String[] args) {
        // 0 <= 값 <1 실수 중에 랜덤값 (난수) 추출
        System.out.println(Math.random());
        System.out.println(Math.random());

        // 0 <= 값 < 10 정수 추출
        System.out.println((int)(Math.random() * 10));

        // 1 ~ 46 까지 중 정수 추출 : Math
        //(int) 0 * 45 <= 값  < 1 * 45  -->   0 + 1 <= 값 < 45 + 1 --->  1<= 값 < 46

        System.out.println((int)((Math.random() * 45) + 1));
     }
}
