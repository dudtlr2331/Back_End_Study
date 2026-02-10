package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1992 {

    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 입력 받기 (문자열이 붙어서 들어오므로 charAt으로 파싱)
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }

    // 분할 정복 함수
    public static void partition(int row, int col, int size) {

        // 1. 압축 가능 여부 확인 (모두 같은 수인가?)
        if(check(row, col, size)) {
            sb.append(board[row][col]); // 압축 성공 시 해당 수 추가
            return;
        }

        // 2. 압축 불가능하면 4등분 (괄호 열기)
        sb.append('(');

        int newSize = size / 2;

        partition(row, col, newSize);                       // 왼쪽 위
        partition(row, col + newSize, newSize);             // 오른쪽 위
        partition(row + newSize, col, newSize);             // 왼쪽 아래
        partition(row + newSize, col + newSize, newSize);   // 오른쪽 아래

        // 4등분 탐색 끝나면 괄호 닫기
        sb.append(')');
    }

    // 현재 영역이 모두 같은 숫자인지 검사
    public static boolean check(int row, int col, int size) {
        int color = board[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}