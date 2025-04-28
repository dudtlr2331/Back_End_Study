public class ExceptionEx09 {
    public void method1(int num){
        System.out.println("시작");

        //num 값에 대한 검사
        if (num >= 100){
            System.out.println("정상입력");
        }else {
            System.out.println("비정상 입력");
        }

        System.out.println("끝");
    }
    public void method2(int num){
        System.out.println("시작");

        try {
            if (num >= 100){
                System.out.println("정상");
            }else {
                System.out.println("100 이상 입력해 주세요.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("끝");
    }
    public void method3(int num) throws Exception {
        System.out.println("시작");

        if (num >= 100){
            System.out.println("정상");
        }else {
            throw new Exception("100 이상 입력해주세요.");
        }

        System.out.println("끝");
    }

    public static void main(String[] args) {
        ExceptionEx09 ex = new ExceptionEx09();
        ex.method2(10);
        ex.method2(100);

        try{
            ex.method3(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
