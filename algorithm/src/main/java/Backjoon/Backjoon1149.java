package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 각 집의 빨, 초, 파 도색 비용을 저장할 배열
        int[][] cost = new int[N][3];
        // i번째 집까지 칠했을 때의 최소 비용을 저장할 DP 테이블
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 집의 비용은 그대로 초기화
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // 두 번째 집부터 N번째 집까지 최소 비용 계산 (점화식 적용)
        for (int i = 1; i < N; i++) {
            // i번째 집을 빨강(0)으로 칠할 때: 이전 집은 초록(1)이나 파랑(2)이어야 함
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];

            // i번째 집을 초록(1)으로 칠할 때: 이전 집은 빨강(0)이나 파랑(2)이어야 함
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];

            // i번째 집을 파랑(2)으로 칠할 때: 이전 집은 빨강(0)이나 초록(1)이어야 함
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        // 마지막 N번째 집의 세 가지 색상 비용 중 최솟값 출력
        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(result);
    }
}