package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1018 {
    public static boolean[][] board;
    public static int min = 64; // 8x8에서 고칠 수 있는 최대 칸수는 64

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        // 1. 보드 입력 받기 (W는 true, B는 false로 저장)
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') board[i][j] = true;
                else board[i][j] = false;
            }
        }

        // 2. 8x8 크기로 자를 수 있는 모든 시작점 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int count = 0;
        boolean color = board[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // 현재 칸이 올바른 색이 아니면 count 증가
                if (board[i][j] != color) {
                    count++;
                }
                // 다음 칸은 색이 바뀌어야 함
                color = (!color);
            }
            // 다음 줄로 넘어갈 때도 색이 바뀌어야 함
            color = (!color);
        }

        // '첫 번째 칸을 기준으로 할 때'와 '반대 색을 기준으로 할 때' 중 최솟값 선택
        // 예: W 기준 10번 고쳐야 한다면 B 기준으로는 (64-10)번 고쳐야 함
        count = Math.min(count, 64 - count);

        // 전체 경우 중 최솟값 갱신
        min = Math.min(min, count);
    }
}