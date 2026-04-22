package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon14890 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (canGo(i, 0, true)) count++;  // 가로 방향 체크
            if (canGo(0, i, false)) count++; // 세로 방향 체크
        }

        System.out.println(count);
    }

    static boolean canGo(int r, int c, boolean isRow) {
        int[] road = new int[N];
        boolean[] visited = new boolean[N]; // 경사로 설치 여부

        // 가로줄 또는 세로줄을 road 배열에 복사
        for (int i = 0; i < N; i++) {
            road[i] = isRow ? map[r][i] : map[i][c];
        }

        for (int i = 0; i < N - 1; i++) {
            // 높이가 같으면 통과
            if (road[i] == road[i + 1]) continue;

            // 높이 차이가 1보다 크면 실패
            if (Math.abs(road[i] - road[i + 1]) > 1) return false;

            // 1. 내려가는 경사로 (다음 칸이 1 낮음)
            if (road[i] - 1 == road[i + 1]) {
                for (int j = i + 1; j <= i + L; j++) {
                    // 범위를 벗어나거나, 높이가 일정하지 않거나, 이미 경사로가 있는 경우
                    if (j >= N || road[i + 1] != road[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            // 2. 올라가는 경사로 (다음 칸이 1 높음)
            else if (road[i] + 1 == road[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    // 범위를 벗어나거나, 높이가 일정하지 않거나, 이미 경사로가 있는 경우
                    if (j < 0 || road[i] != road[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }

        return true;
    }
}