package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 회의 정보를 담을 2차원 배열 [N][2]
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 2. 정렬 로직 (Comparator 사용)
        Arrays.sort(time, (o1, o2) -> {
            // 종료 시간이 같다면 시작 시간이 빠른 순으로 정렬
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            // 그 외에는 종료 시간이 빠른 순으로 정렬
            return o1[1] - o2[1];
        });

        int count = 0;
        int prev_end_time = 0;

        // 3. 그리디 선택 로직
        for (int i = 0; i < N; i++) {
            // 직전 회의의 종료 시간보다 현재 회의의 시작 시간이 크거나 같다면 선택 가능
            if (prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1]; // 종료 시간 갱신
                count++;
            }
        }

        System.out.println(count);
    }
}