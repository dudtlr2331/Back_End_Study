public class ExceptionEx06 {
    public static void main(String[] args) {
        System.out.println("시작");

        try {
            int[] datas = {0, 2, 10};

            int result = datas[2] / datas[0];
            System.out.println("결과 : " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
//        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }



        System.out.println("끝");
    }
}
