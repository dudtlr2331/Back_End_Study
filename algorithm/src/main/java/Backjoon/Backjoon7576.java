package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 좌표를 담을 클래스 (x, y)
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Backjoon7576 {
    static int M, N; // M: 가로, N: 세로
    static int[][] board; // 토마토 상자
    static Queue<Point> q = new LinkedList<>(); // BFS를 위한 큐

    // 상하좌우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 세로 칸 수

        board = new int[N][M];

        // 1. 입력 받기 & 익은 토마토 큐에 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토(1)라면 시작점이므로 큐에 바로 넣음!
                if (board[i][j] == 1) {
                    q.add(new Point(i, j));
                }
            }
        }

        // 2. BFS 시작 (모든 익은 토마토들이 동시에 퍼져나감)
        bfs();

        // 3. 결과 확인
        int maxDays = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안 익은 토마토(0)가 하나라도 남았다면 실패
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                // 가장 오래 걸린 날짜 찾기
                maxDays = Math.max(maxDays, board[i][j]);
            }
        }

        // 시작이 1이었으므로, 실제 걸린 날짜는 -1 해줘야 함
        // 예: 1일 뒤에 익으면 2가 저장되어 있음 -> 정답은 1일
        System.out.println(maxDays - 1);
    }

    // BFS 탐색 함수
    static void bfs() {
        while (!q.isEmpty()) {
            Point current = q.poll(); // 하나 꺼냄

            // 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                // 상자 범위를 벗어나면 패스
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                // 안 익은 토마토(0)인 경우에만 익게 만듦
                if (board[nextX][nextY] == 0) {
                    // 며칠째에 익었는지 기록 (이전 값 + 1)
                    board[nextX][nextY] = board[current.x][current.y] + 1;
                    q.add(new Point(nextX, nextY)); // 큐에 추가
                }
            }
        }
    }
}