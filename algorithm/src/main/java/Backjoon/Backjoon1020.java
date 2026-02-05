package Backjoon;

import java.io.*;
import java.util.*;

public class Backjoon1020 {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    // 이동 방향 (상, 하, 좌, 우)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 T
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 (열)
            N = Integer.parseInt(st.nextToken()); // 세로 (행)
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            // 1. 배추 위치 입력 받기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 문제에서 X는 가로, Y는 세로 좌표로 주어짐
                map[y][x] = 1;
            }

            // 2. 덩어리(지렁이) 개수 세기
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 배추가 있고(1) + 아직 방문하지 않은 곳이라면 -> 새로운 덩어리 발견!
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(j, i); // 연결된 배추들 다 체크하러 출발 (x, y 순서 주의)
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    // 재귀함수 (DFS)
    static void dfs(int x, int y) {
        visited[y][x] = true; // 현재 위치 방문 처리

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 1) 맵 범위 안에 있고
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                // 2) 배추가 있으며, 아직 방문 안 했다면 -> 재귀 호출
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}