package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 스크린 크기
        int M = Integer.parseInt(st.nextToken()); // 바구니 크기
        int J = Integer.parseInt(br.readLine());  // 사과 개수

        // 바구니의 초기 위치 (1부터 M까지 차지)
        int left = 1;
        int right = M;
        int totalDistance = 0;

        for (int i = 0; i < J; i++) {
            int applePos = Integer.parseInt(br.readLine());

            // 1. 사과가 바구니의 왼쪽에 떨어질 때
            if (applePos < left) {
                int dist = left - applePos; // 이동해야 할 거리
                totalDistance += dist;

                // 바구니 좌표 업데이트 (왼쪽으로 이동)
                left -= dist;
                right -= dist;
            }
            // 2. 사과가 바구니의 오른쪽에 떨어질 때
            else if (applePos > right) {
                int dist = applePos - right; // 이동해야 할 거리
                totalDistance += dist;

                // 바구니 좌표 업데이트 (오른쪽으로 이동)
                left += dist;
                right += dist;
            }
            // 3. 사과가 이미 바구니 범위 안에 있을 때 (이동 없음)
        }

        System.out.println(totalDistance);
    }
}
