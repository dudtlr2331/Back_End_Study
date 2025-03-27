package wrapper1;

public class IntegerEx04 {
    public static void main(String[] args) {
        //오토박싱
        // 기본 자료형 -> 객체
        Integer i1 = Integer.valueOf(1);
        Integer i2 = 2;


        //언박싱
        int i3 = i1;

        int sum = i1 + 20;
        System.out.println(sum);

        Integer i4 = Integer.valueOf(4);

        int sum1 = i4 + i1;
        System.out.println(sum1);

        Integer i5 = Integer.valueOf(11);
        Integer i6 = Integer.valueOf(11);

        System.out.println(i5 == i6);

//        Integer i7 = new Integer(11);
//        Integer i8 = new Integer(11);

//        System.out.println(i7 == i8);

    }
}
