import java.util.Scanner;

public class Backjoon4375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력이 없을 때까지 계속 읽음 (EOF 처리)
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int num = 0;

            for (int i = 1; ; i++) {
                // 이전 수에 10을 곱하고 1을 더한 뒤 n으로 나눈 나머지를 구함
                num = (num * 10 + 1) % n;

                // 나머지가 0이면 n의 배수이므로 자릿수(i) 출력 후 종료
                if (num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}