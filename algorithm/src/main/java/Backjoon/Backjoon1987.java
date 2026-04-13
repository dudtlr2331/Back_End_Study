package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1987 {
    static int R, C;
    static int[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부 (A-Z)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                // 알파벳을 0~25 사이의 숫자로 변환하여 저장
                board[i][j] = line.charAt(j) - 'A';
            }
        }

        // 시작 지점(0,0)의 알파벳 방문 처리 후 DFS 시작
        visited[board[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    static void dfs(int r, int c, int count) {
        // 최대 경로 길이 갱신
        maxCount = Math.max(maxCount, count);

        // 만약 26개 알파벳을 다 찾았다면 더 이상 탐색 불필요 (최적화)
        if (maxCount == 26) return;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                int alphabet = board[nr][nc];

                // 아직 방문하지 않은 알파벳인 경우만 이동
                if (!visited[alphabet]) {
                    visited[alphabet] = true; // 방문 표시
                    dfs(nr, nc, count + 1);
                    visited[alphabet] = false; // 백트래킹 (원상 복구)
                }
            }
        }
    }
}