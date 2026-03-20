package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 1인 경우 예외 처리
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = 1; // 2x1 한 개
        dp[2] = 3; // (2x1 두 개), (1x2 두 개), (2x2 한 개)

        for (int i = 3; i <= n; i++) {
            // 점화식: D[n] = D[n-1] + 2 * D[n-2]
            // 매 연산마다 10007로 나누어 오버플로우 방지
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}