package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 1. 초기값 설정 (계단 개수에 따른 예외 처리 포함)
        dp[1] = score[1];

        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }

        if (n >= 3) {
            // 3번째 계단은 (1,3) 혹은 (2,3) 중 큰 값
            dp[3] = Math.max(score[1], score[2]) + score[3];
        }

        // 2. 점화식을 이용한 반복문 (Bottom-Up)
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }

        // 3. 결과 출력
        System.out.println(dp[n]);
    }
}