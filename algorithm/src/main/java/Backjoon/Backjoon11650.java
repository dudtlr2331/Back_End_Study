package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon11650 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 2차원 배열 선언 (N개의 좌표, 각 좌표는 x와 y 2개)
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x
            points[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        // 2. Arrays.sort에 Comparator를 사용하여 정렬 기준 정의
        Arrays.sort(points, (e1, e2) -> {
            // x좌표가 같다면 y좌표를 비교
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                // x좌표가 다르면 x좌표를 비교
                return e1[0] - e2[0];
            }
        });

        // 3. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}