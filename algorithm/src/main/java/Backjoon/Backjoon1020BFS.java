package Backjoon;

import java.io.*;
import java.util.*;

public class Backjoon1020BFS {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 큐에 좌표를 넣기 위한 클래스
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 (열)
            N = Integer.parseInt(st.nextToken()); // 세로 (행)
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            // 배추 심기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int count = 0; // 지렁이 수

            // 전체 맵 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 배추가 있고, 방문 안 한 곳이면 BFS 시작
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(j, i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    // BFS 탐색 (Queue 사용)
    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        // 1. 시작점 큐에 넣고 방문 처리
        q.offer(new Point(x, y));
        visited[y][x] = true;

        // 2. 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            Point current = q.poll(); // 큐에서 하나 꺼냄

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 체크
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    // 배추가 있고 방문 안 했으면 큐에 추가
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true; // 큐에 넣을 때 방문 처리 (중복 방지)
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}