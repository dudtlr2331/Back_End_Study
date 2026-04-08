package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon2589 {
    static int R, C;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxDist = 0;

    static class Node {
        int r, c, dist;
        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 1. 모든 칸을 순회하며 육지(L)인 경우 BFS 시작
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxDist);
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        q.add(new Node(r, c, 0));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // 현재까지의 최단 거리 중 최대값 갱신
            maxDist = Math.max(maxDist, curr.dist);

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (map[nr][nc] == 'L' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc, curr.dist + 1));
                    }
                }
            }
        }
    }
}