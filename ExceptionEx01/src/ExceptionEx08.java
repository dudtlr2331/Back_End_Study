public class ExceptionEx08 {
    public static void main(String[] args) {
        try {
            if (args.length != 1){
                System.out.println("비정상");
//            throw new Exception();
                throw new Exception("값을 입력하셔야 합니다.");

            } else {
                System.out.println("정상");
            }
        } catch (Exception e) {
//            System.out.println("[에러]");
            System.out.println("[에러]" + e.getMessage());
        }
        
    }
}
