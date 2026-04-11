package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon17071 {
    static int N, K;
    // visited[홀수/짝수][위치] = 최소 도달 시간
    static int[][] visited = new int[2][500001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        // 방문 배열 초기화
        Arrays.fill(visited[0], -1);
        Arrays.fill(visited[1], -1);

        bfs();

        int time = 0;
        int brotherPos = K;
        int result = -1;

        // 동생이 이동하는 시간에 맞춰 수빈이가 해당 위치에 미리 올 수 있는지 확인
        while (brotherPos <= 500000) {
            int mod = time % 2;

            // 수빈이가 동생보다 먼저 혹은 동시에 해당 위치에 도착했고,
            // 도착 시간이 동생과 같은 홀수/짝수라면 (제자리 걸음으로 만남 가능)
            if (visited[mod][brotherPos] != -1 && visited[mod][brotherPos] <= time) {
                result = time;
                break;
            }

            time++;
            brotherPos += time; // 가속도 반영된 동생의 다음 위치
        }

        System.out.println(result);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[0][N] = 0;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            int mod = time % 2;

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                for (int next : new int[]{now - 1, now + 1, now * 2}) {
                    if (next >= 0 && next <= 500000 && visited[mod][next] == -1) {
                        visited[mod][next] = time;
                        q.add(next);
                    }
                }
            }
        }
    }
}