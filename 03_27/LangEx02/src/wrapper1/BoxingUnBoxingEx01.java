package wrapper1;

public class BoxingUnBoxingEx01 {
    public static void main(String[] args) {
        //Boxing
        Integer obj = 100;
        System.out.println("value is " + obj.intValue());

        //UnBoxing
        int value = obj;
        System.out.println("value is " + value);

        //연산 시 UnBoxing
        int result = obj + 100;
        System.out.println("result is " + result);
    }
}
