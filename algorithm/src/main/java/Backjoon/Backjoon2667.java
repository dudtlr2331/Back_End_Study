package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 이동을 위한 배열
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> results = new ArrayList<>(); // 단지별 집의 수를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        // 1. 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 2. 전체 지도를 순회하며 '집이 있고 방문하지 않은 곳'을 찾으면 BFS 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    results.add(bfs(i, j));
                }
            }
        }

        // 3. 결과 정렬 및 출력
        Collections.sort(results);
        System.out.println(results.size()); // 총 단지 수
        for (int count : results) {
            System.out.println(count); // 각 단지 내 집의 수
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int houseCount = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                // 지도를 벗어나지 않고, 집이 있으며, 방문하지 않은 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        houseCount++;
                    }
                }
            }
        }
        return houseCount;
    }
}