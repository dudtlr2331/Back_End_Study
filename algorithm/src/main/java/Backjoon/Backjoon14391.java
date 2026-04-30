package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon14391 {
    static int N, M;
    static int[][] paper;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = line.charAt(j) - '0';
            }
        }

        int maxScore = 0;

        // 1. 모든 칸의 상태를 비트로 결정 (0: 가로, 1: 세로)
        // 1 << (N*M) 은 전체 칸에 대한 모든 조합의 수
        for (int s = 0; s < (1 << (N * M)); s++) {
            int totalSum = 0;

            // 2. 가로 조각 합 계산
            for (int i = 0; i < N; i++) {
                int currentVal = 0;
                for (int j = 0; j < M; j++) {
                    int k = i * M + j; // 2차원 좌표를 1차원 인덱스로 변환

                    // 해당 비트가 0(가로)인 경우
                    if ((s & (1 << k)) == 0) {
                        currentVal = currentVal * 10 + paper[i][j];
                    } else {
                        // 세로 비트를 만나면 지금까지의 가로 조각 합산
                        totalSum += currentVal;
                        currentVal = 0;
                    }
                }
                totalSum += currentVal; // 줄이 끝날 때 남은 값 합산
            }

            // 3. 세로 조각 합 계산
            for (int j = 0; j < M; j++) {
                int currentVal = 0;
                for (int i = 0; i < N; i++) {
                    int k = i * M + j;

                    // 해당 비트가 1(세로)인 경우
                    if ((s & (1 << k)) != 0) {
                        currentVal = currentVal * 10 + paper[i][j];
                    } else {
                        // 가로 비트를 만나면 지금까지의 세로 조각 합산
                        totalSum += currentVal;
                        currentVal = 0;
                    }
                }
                totalSum += currentVal; // 줄이 끝날 때 남은 값 합산
            }

            maxScore = Math.max(maxScore, totalSum);
        }

        System.out.println(maxScore);
    }
}