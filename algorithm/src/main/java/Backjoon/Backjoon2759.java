package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon2759 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 설정
        dp[1] = stairs[1];
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        // 3번째 계단부터 점화식 적용
        for (int i = 3; i <= n; i++) {
            // i번째 계단에 도달하는 방법은 딱 두 가지입니다.
            // 1. (i-2)번째 계단에서 바로 2칸 뛰어오는 경우
            // 2. (i-3)번째 계단 -> (i-1)번째 계단 -> i번째 계단 (1칸씩 두 번은 안 되므로)
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}