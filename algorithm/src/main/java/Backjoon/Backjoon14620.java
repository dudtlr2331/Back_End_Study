package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon14620 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int minCost = Integer.MAX_VALUE;
    static int[] dr = {0, -1, 1, 0, 0}; // 제자리, 상, 하, 좌, 우
    static int[] dc = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작 (심은 꽃의 개수, 현재까지의 비용)
        dfs(0, 0);

        System.out.println(minCost);
    }

    static void dfs(int count, int sum) {
        // 꽃 3개를 모두 심었다면 최소 비용 갱신
        if (count == 3) {
            minCost = Math.min(minCost, sum);
            return;
        }

        // 가장자리를 제외한 (1, 1)부터 (N-2, N-2)까지 탐색
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                // 현재 위치에 꽃을 피울 수 있는지 확인
                if (canBloom(i, j)) {
                    int cost = getCost(i, j);
                    visit(i, j, true); // 방문 처리
                    dfs(count + 1, sum + cost);
                    visit(i, j, false); // 백트래킹 (원상복구)
                }
            }
        }
    }

    // 꽃을 피울 수 있는지(겹치지 않는지) 체크
    static boolean canBloom(int r, int c) {
        for (int i = 0; i < 5; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (visited[nr][nc]) return false;
        }
        return true;
    }

    // 꽃이 차지하는 5칸의 비용 합계 계산
    static int getCost(int r, int c) {
        int cost = 0;
        for (int i = 0; i < 5; i++) {
            cost += map[r + dr[i]][c + dc[i]];
        }
        return cost;
    }

    // 방문 처리 및 해제
    static void visit(int r, int c, boolean val) {
        for (int i = 0; i < 5; i++) {
            visited[r + dr[i]][c + dc[i]] = val;
        }
    }
}