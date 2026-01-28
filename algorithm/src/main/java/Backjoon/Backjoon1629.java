package algorithm.src.main.java.Backjoon;

import java.util.Scanner;

public class Backjoon1629 {
    public static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        C = sc.nextLong();

        System.out.println(pow(a, b));
    }

    public static long pow(long a, long b) {

        // 1번 곱할 시 바로 나머지 구하기
        if (b == 1) {
            return a % C;
        }

        // 지수의 절반에 해당하는 값을 재귀적으로 구함
        long temp = pow(a, b / 2);

        // 지수가 홀수일 때
        if (b % 2 == 1) {
            return (temp * temp % C) * (a % C) % C;
        }

        // 지수가 짝수일 때 (A^(B/2) * A^(B/2)) % C
        return temp * temp % C;
    }
}