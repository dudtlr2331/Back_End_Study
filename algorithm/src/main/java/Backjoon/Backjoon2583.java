package Backjoon;

import java.io.*;
import java.util.*;

public class Backjoon2583 {
    static int M, N, K;
    static int[][] map;
    static int count; // 각 영역의 넓이를 셀 변수

    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로 (Y)
        N = Integer.parseInt(st.nextToken()); // 가로 (X)
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        map = new int[M][N]; // 0으로 자동 초기화

        // 1. 직사각형 영역 채우기 (벽 세우기)
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 직사각형 범위만큼 1로 표시
            // 문제의 좌표계와 배열 인덱스를 그대로 매칭해도 넓이는 동일함
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        // 2. 빈 영역 탐색 (DFS)
        ArrayList<Integer> areas = new ArrayList<>(); // 각 영역의 넓이 저장

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 빈 공간(0)이면 탐색 시작
                if (map[i][j] == 0) {
                    count = 0; // 넓이 초기화
                    dfs(j, i); // (x, y) 순서로 넘김
                    areas.add(count);
                }
            }
        }

        // 3. 결과 정렬 및 출력
        Collections.sort(areas); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append('\n'); // 총 영역 개수

        for (int area : areas) {
            sb.append(area).append(' ');
        }

        System.out.println(sb);
    }

    // 깊이 우선 탐색 (DFS)
    static void dfs(int x, int y) {
        map[y][x] = 1; // 방문 처리 (다시 방문 안 하도록 1로 변경)
        count++; // 넓이 증가

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 맵 범위 체크
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                // 빈 공간(0)이라면 계속 탐색
                if (map[ny][nx] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
