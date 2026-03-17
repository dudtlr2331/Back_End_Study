package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1780 {
    static int[][] board;
    static int minusOne = 0; // -1로만 채워진 종이 수
    static int zero = 0;     // 0으로만 채워진 종이 수
    static int plusOne = 0;  // 1로만 채워진 종이 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할 정복 시작 (0, 0 위치에서 N 크기만큼)
        divide(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    // 1. 현재 영역이 모두 같은 숫자인지 체크하는 함수
    static boolean isSame(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) return false;
            }
        }
        return true;
    }

    // 2. 재귀적으로 종이를 자르는 함수 (분할 정복)
    static void divide(int row, int col, int size) {
        // 모든 숫자가 같다면 해당 숫자 카운트 증가
        if (isSame(row, col, size)) {
            if (board[row][col] == -1) minusOne++;
            else if (board[row][col] == 0) zero++;
            else plusOne++;
        } else {
            // 숫자가 다르면 9등분 (size/3)
            int nextSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // (0,0), (0,3), (0,6), (3,0) ... 순서로 재귀 호출
                    divide(row + i * nextSize, col + j * nextSize, nextSize);
                }
            }
        }
    }
}