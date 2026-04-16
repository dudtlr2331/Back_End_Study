package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon15684 {
    static int N, M, H;
    static int[][] map;
    static int answer = 4; // 최대 3개까지만 가능하므로 4로 초기화
    static boolean finish = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;     // b번에서 b+1번으로 가는 가로선
            map[a][b + 1] = 2; // b+1번에서 b번으로 가는 가로선
        }

        // 가로선을 0개부터 3개까지 늘려가며 탐색
        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);
            if (finish) break;
        }

        System.out.println(finish ? answer : -1);
    }

    // count: 현재 설치한 가로선 수, target: 설치해야 할 목표 가로선 수
    static void dfs(int r, int count, int target) {
        if (finish) return;
        if (count == target) {
            if (check()) {
                answer = count;
                finish = true;
            }
            return;
        }

        for (int i = r; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                // 현재 위치, 왼쪽, 오른쪽에 가로선이 없는지 확인
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, count + 1, target);
                    map[i][j] = 0; // 백트래킹: 원상복구
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    // 모든 세로선이 자기 번호로 돌아오는지 확인
    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int current = i;
            for (int j = 1; j <= H; j++) {
                if (map[j][current] == 1) current++; // 오른쪽으로 이동
                else if (map[j][current] == 2) current--; // 왼쪽으로 이동
            }
            if (current != i) return false;
        }
        return true;
    }
}