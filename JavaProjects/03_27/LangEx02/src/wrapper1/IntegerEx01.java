package wrapper1;

public class IntegerEx01 {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf("10");

        //오토박싱
        Integer i3 = 10;

//        Integer i4 = Integer.valueOf("a10");

        System.out.println(i2);
        System.out.println(i3);

        //형변환
        byte b = i2.byteValue();
        float f = i2.floatValue();
        String s = i2.toString();
        System.out.println(b);
        System.out.println(f);
        System.out.println(s);
    }
}
