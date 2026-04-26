package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon2234 {
    static int N, M;
    static int[][] map;
    static int[][] roomMap; // 각 칸이 몇 번 방인지 기록
    static int[] dr = {0, -1, 0, 1}; // 서(0), 북(1), 동(2), 남(3) 순서 (비트 1, 2, 4, 8 대응)
    static int[] dc = {-1, 0, 1, 0};
    static Map<Integer, Integer> roomSizeMap = new HashMap<>(); // 방 번호별 크기 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 행
        map = new int[M][N];
        roomMap = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomCount = 0;
        int maxRoomSize = 0;
        int roomIdx = 1;

        // 1 & 2. 방 개수와 최대 크기 구하기 + 방 번호 매기기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (roomMap[i][j] == 0) {
                    int size = bfs(i, j, roomIdx);
                    roomSizeMap.put(roomIdx, size);
                    maxRoomSize = Math.max(maxRoomSize, size);
                    roomCount++;
                    roomIdx++;
                }
            }
        }

        // 3. 벽 하나 부셔서 만들 수 있는 최대 방 크기 구하기
        int maxAfterBreak = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int ni = i + dr[d];
                    int nj = j + dc[d];

                    if (ni >= 0 && ni < M && nj >= 0 && nj < N) {
                        // 인접한 칸이 서로 다른 방이라면 두 방의 크기 합 계산
                        if (roomMap[i][j] != roomMap[ni][nj]) {
                            maxAfterBreak = Math.max(maxAfterBreak,
                                    roomSizeMap.get(roomMap[i][j]) + roomSizeMap.get(roomMap[ni][nj]));
                        }
                    }
                }
            }
        }

        System.out.println(roomCount);
        System.out.println(maxRoomSize);
        System.out.println(maxAfterBreak);
    }

    static int bfs(int r, int c, int idx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        roomMap[r][c] = idx;
        int size = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                // 비트 연산으로 벽이 있는지 확인 (1, 2, 4, 8)
                if ((map[curr[0]][curr[1]] & (1 << i)) == 0) {
                    int nr = curr[0] + dr[i];
                    int nc = curr[1] + dc[i];

                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && roomMap[nr][nc] == 0) {
                        roomMap[nr][nc] = idx;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return size;
    }
}