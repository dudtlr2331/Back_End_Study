package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1189 {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 시작점: 왼쪽 아래 (R-1, 0)
        // 시작할 때 거리(depth)는 1부터 시작
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int dist) {
        // 도착점: 오른쪽 위 (0, C-1)
        // 거리가 K일 때 도착지에 왔는지 확인
        if (r == 0 && c == C - 1) {
            if (dist == K) {
                answer++;
            }
            return;
        }

        // 거리가 이미 K를 넘었다면 더 이상 탐색할 필요 없음 (가지치기)
        if (dist >= K) return;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 맵 범위 내에 있고, 방문하지 않았으며, 'T'가 아닌 경우
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if (!visited[nr][nc] && map[nr][nc] != 'T') {
                    visited[nr][nc] = true;   // 방문 표시
                    dfs(nr, nc, dist + 1);
                    visited[nr][nc] = false;  // 백트래킹 (원상복구)
                }
            }
        }
    }
}