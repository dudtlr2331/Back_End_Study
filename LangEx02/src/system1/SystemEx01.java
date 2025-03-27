package system1;

public class SystemEx01 {
    public static void main(String[] args) {
        // 프로그램의 강제 중지

        System.out.println("시작");

        //입력값 검사
        if(args.length != 1) {
            System.out.println("error");
            System.out.println("1개를 입력하셔야 합니다.");

            System.exit(0);
        }else {
            System.out.println("정상 입력");
        }

        System.out.println("끝");

    }
}
