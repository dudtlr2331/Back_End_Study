public class LambdaEx01 {
    public static void main(String[] args) {
        //인터페이스 구현하는 방법

        // 1. 클래스 implements 인터페이스
        // 2. 익명 내부클래스

        LambdaInter lambda = new LambdaInter() {
            @Override
            public void method() {
                System.out.println("method 호출");
            }

//            public void method2() {
//                System.out.println("method2 호출");
//            }
        };

        lambda.method();

        // 람다식으로 변경가능
//        LambdaInter f2 = () -> {
//                System.out.println("method 호출");
//        };
//
//        f2.method();
    }
}
