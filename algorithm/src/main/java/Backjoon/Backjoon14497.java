package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon14497 {
    static int N, M;
    static int x1, y1, x2, y2;
    static char[][] map;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 내부 클래스로 선언하여 다른 파일과의 충돌 방지
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 문제의 좌표는 1부터 시작하므로 0부터 시작하도록 -1 처리
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        map = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], -1); // 미방문 상태로 초기화
        }

        bfs01();

        System.out.println(dist[x2][y2]);
    }

    static void bfs01() {
        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(new Node(x1, y1));
        dist[x1][y1] = 0;

        while (!deque.isEmpty()) {
            Node curr = deque.pollFirst();

            if (curr.r == x2 && curr.c == y2) break;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (dist[nr][nc] != -1) continue; // 이미 방문함

                // '0'을 만나면 가중치가 0이므로 Deque의 맨 앞에 넣음
                if (map[nr][nc] == '0') {
                    dist[nr][nc] = dist[curr.r][curr.c];
                    deque.addFirst(new Node(nr, nc));
                }
                // '1'이나 '#'을 만나면 가중치가 1이므로 Deque의 맨 뒤에 넣음
                else {
                    dist[nr][nc] = dist[curr.r][curr.c] + 1;
                    deque.addLast(new Node(nr, nc));
                }
            }
        }
    }
}