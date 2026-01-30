import java.util.Scanner;

public class MazeDFS {
    // 3x3 맵과 방문 여부를 저장할 배열
    static int[][] map = new int[3][3];
    static boolean[][] visited = new boolean[3][3];

    // 이동 방향 설정: 오른쪽(x+1), 아래(y+1), 왼쪽(x-1), 위(y-1) 순서
    // 이 순서대로 재귀를 호출해야 예시와 같은 출력값이 나옵니다.
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 맵 입력 받기
        // y가 행(세로), x가 열(가로) 역할을 합니다.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 2. (0,0) 지점이 갈 수 있는 곳(1)이라면 탐색 시작
        if (map[0][0] == 1) {
            dfs(0, 0);
        }

        sc.close();
    }

    // 재귀함수(DFS) 정의
    public static void dfs(int x, int y) {
        // 현재 위치 방문 처리
        visited[y][x] = true;

        // 현재 좌표 출력
        System.out.println("(" + x + "," + y + ")");

        // 4방향 탐색 (오른쪽 -> 아래 -> 왼쪽 -> 위)
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 1) 맵 범위를 벗어나지 않는지 확인
            if (nextX >= 0 && nextY >= 0 && nextX < 3 && nextY < 3) {
                // 2) 갈 수 있는 지역(1)이고, 아직 방문하지 않은 곳인지 확인
                if (map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    // 재귀 호출
                    dfs(nextX, nextY);
                }
            }
        }
    }
}