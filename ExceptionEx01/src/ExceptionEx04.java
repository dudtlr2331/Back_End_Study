public class ExceptionEx04 {
    public static void main(String[] args) {
        System.out.println( "시작" );

        int[] datas = { 0, 2, 10 };


        // ArithmeticException / ArrayIndexOutOfBoundsException
        try {
            int result = datas[3] / datas[0];
            System.out.println("결과 : " + result);
            // if ~ elseif ~ else -

            // 개별처리
            //} catch (ArithmeticException e) {
            //} catch (ArrayIndexOutOfBoundsException e) {

            // 통합처리
        } catch (Exception e) {
        }

        System.out.println( "끝" );
    }
}