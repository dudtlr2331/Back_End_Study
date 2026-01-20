import java.util.Scanner;

public class Backjoon1629 {
    public static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();

        // A^B % C 계산 시작
        System.out.println(pow(A, B));
    }

    // 분할 정복을 이용한 거듭제곱 함수
    public static long pow(long A, long exponent) {
        // 지수가 1일 때는 A % C를 바로 반환 (기본 케이스)
        if (exponent == 1) {
            return A % C;
        }

        // 지수의 절반에 해당하는 값을 재귀적으로 구함
        long temp = pow(A, exponent / 2);

        /*
         * 구한 절반값을 서로 곱함.
         * 이때 (temp * temp) 과정에서 long 범위를 넘을 수 있으므로
         * 매번 % C를 해주는 것이 중요합니다.
         */
        if (exponent % 2 == 1) {
            // 지수가 홀수일 때: (A^(B/2) * A^(B/2) * A) % C
            // 연산 중간중간 % C를 해주어 오버플로우를 방지합니다.
            return (temp * temp % C) * (A % C) % C;
        }

        // 지수가 짝수일 때: (A^(B/2) * A^(B/2)) % C
        return temp * temp % C;
    }
}