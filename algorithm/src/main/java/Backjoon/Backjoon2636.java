package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon2636 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cheeseCount = 0;
    static int lastCheese = 0;
    static int time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheeseCount++;
            }
        }

        // 치즈가 다 녹을 때까지 반복
        while (cheeseCount > 0) {
            lastCheese = cheeseCount; // 녹기 전 치즈 개수 저장
            time++;
            visited = new boolean[N][M];
            bfs();
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // 가장자리 (0,0)은 항상 공기
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    // 치즈를 만나면 녹이고, 더 이상 나아가지 않음 (가장자리만 녹임)
                    cheeseCount--;
                    map[nx][ny] = 0;
                    visited[nx][ny] = true;
                } else {
                    // 공기면 계속 탐색
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}