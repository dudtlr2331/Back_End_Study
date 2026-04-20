package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon1285 {
    static int N;
    static int[] map; // 각 행의 상태를 비트로 저장
    static int minT = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int bit = 0;
            for (int j = 0; j < N; j++) {
                // T(뒷면)를 1, H(앞면)를 0으로 비트 저장
                if (line.charAt(j) == 'T') {
                    bit |= (1 << j);
                }
            }
            map[i] = bit;
        }

        // 1. 행을 뒤집는 모든 경우의 수 (2^N) 탐색
        // bit가 1인 자리는 해당 행을 뒤집는다는 의미
        for (int bit = 0; bit < (1 << N); bit++) {
            int currentTotalT = 0;

            // 2. 각 열(j)을 검사하며 그리디하게 뒤집을지 결정
            for (int j = 0; j < N; j++) {
                int countT = 0;
                for (int i = 0; i < N; i++) {
                    int curr = map[i];
                    // 행(bit)이 뒤집혔다면 상태 반전
                    if ((bit & (1 << i)) != 0) {
                        curr = ~curr;
                    }

                    // 현재 열(j)의 동전이 T인지 확인
                    if ((curr & (1 << j)) != 0) {
                        countT++;
                    }
                }
                // 3. 열을 뒤집었을 때와 안 뒤집었을 때 중 T가 적은 쪽 선택
                currentTotalT += Math.min(countT, N - countT);
            }

            minT = Math.min(minT, currentTotalT);
        }

        System.out.println(minT);
    }
}