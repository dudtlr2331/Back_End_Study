import java.util.*;
import java.io.*;

public class BFS {
    static int N, M;
    static int[][] map;
    static int[][] dist; // 거리를 저장할 배열
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(startX, startY);

        // 최단 거리 출력
        System.out.println(dist[endX][endY]);

        // 맵의 최종 상태(거리 누적) 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        dist[x][y] = 1; // 시작 위치 1칸 소모

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curX = curr[0];
            int curY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 범위 내에 있고, 갈 수 있는 길(1)이며, 아직 방문하지 않은 경우(0)
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[curX][curY] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}