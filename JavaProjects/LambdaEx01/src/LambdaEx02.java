public class LambdaEx02 {
    public static void main(String[] args) {
//        LambdaInter1 f1 = () -> {
//            System.out.println("method 호출");
//        };

//        LambdaInter1 f1 = (x) -> {
//            System.out.println("method 호출" + x);
//        };

//        LambdaInter1 f1 = (x, y) -> {
//            System.out.println("method 호출" + x + " , " + y);
//        };

        LambdaInter1 f1 = (x, y) -> {
           return x + y;
        };

        LambdaInter1 f2 = (x, y) -> x + y;


        int result = f2.method(10,20);
        System.out.println(result);
    }
}
