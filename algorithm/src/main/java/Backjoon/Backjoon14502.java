package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon14502 {
    static int N, M;
    static int[][] map;
    static int[][] tempMap;
    static int maxSafeZone = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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
            }
        }

        // 1. 벽 세우기 시작 (조합/백트래킹)
        buildWall(0);

        System.out.println(maxSafeZone);
    }

    // 벽 3개를 세우는 모든 경우의 수를 찾는 함수
    static void buildWall(int count) {
        if (count == 3) {
            // 2. 벽이 3개 세워졌으면 바이러스 퍼뜨리기 시뮬레이션
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈칸이면
                    map[i][j] = 1;   // 벽 세우기
                    buildWall(count + 1);
                    map[i][j] = 0;   // 다시 원상복구 (백트래킹)
                }
            }
        }
    }

    // 바이러스를 퍼뜨리는 BFS 함수
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        tempMap = new int[N][M];

        // 맵 복사 및 초기 바이러스 위치 큐에 삽입
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
                if (tempMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (tempMap[nx][ny] == 0) { // 빈칸으로만 퍼짐
                        tempMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 3. 안전 영역 크기 계산
        calculateSafeZone(tempMap);
    }

    static void calculateSafeZone(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) count++;
            }
        }
        maxSafeZone = Math.max(maxSafeZone, count);
    }
}