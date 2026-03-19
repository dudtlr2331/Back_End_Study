package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon11726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 1인 경우를 대비해 배열 크기를 넉넉히 잡거나 예외 처리를 합니다.
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = 1;
        dp[2] = 2;

        // 점화식을 이용한 보텀업(Bottom-Up) 방식
        for (int i = 3; i <= n; i++) {
            // 연산 과정에서 미리 10007로 나눠야 오버플로우를 방지할 수 있습니다.
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}