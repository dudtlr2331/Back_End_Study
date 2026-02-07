package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2630 {

    static int white = 0; // 하얀색 색종이 개수 (0)
    static int blue = 0;  // 파란색 색종이 개수 (1)
    static int[][] board; // 색종이 정보를 담을 2차원 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 한 변의 길이 (2, 4, 8, 16, 32, 64, 128)

        board = new int[N][N];

        // 배열 입력 받기
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할 정복 시작 (행, 열, 크기)
        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    // 분할 정복 함수
    public static void partition(int row, int col, int size) {

        // 1. 현재 영역이 모두 같은 색상인지 체크
        if(colorCheck(row, col, size)) {
            // 모두 같은 색이면 해당 색상 카운트 증가
            if(board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return; // 더 이상 쪼갤 필요 없으므로 리턴
        }

        // 2. 색상이 섞여 있다면 4등분으로 쪼개서 재귀 호출
        int newSize = size / 2; // 절반 사이즈

        partition(row, col, newSize);                       // 2사분면 (왼쪽 위)
        partition(row, col + newSize, newSize);             // 1사분면 (오른쪽 위)
        partition(row + newSize, col, newSize);             // 3사분면 (왼쪽 아래)
        partition(row + newSize, col + newSize, newSize);   // 4사분면 (오른쪽 아래)
    }

    // 현재 영역이 모두 같은 색인지 검사하는 함수
    public static boolean colorCheck(int row, int col, int size) {

        int color = board[row][col]; // 첫 번째 칸의 색상을 기준으로 삼음

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                // 하나라도 다른 색이 나오면 false 리턴
                if(board[i][j] != color) {
                    return false;
                }
            }
        }

        // 반복문을 무사히 통과했다면 모두 같은 색이라는 뜻
        return true;
    }
}