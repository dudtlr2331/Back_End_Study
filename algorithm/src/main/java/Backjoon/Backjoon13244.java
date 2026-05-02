package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon13244 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 정점의 개수
            int M = Integer.parseInt(br.readLine()); // 간선의 개수

            List<Integer>[] adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }

            // 1. 트리의 조건: 간선의 개수는 N-1개여야 함
            if (M != N - 1) {
                System.out.println("graph");
                continue;
            }

            // 2. 트리의 조건: 모든 정점이 연결되어 있어야 함 (BFS 확인)
            if (isConnected(N, adj)) {
                System.out.println("tree");
            } else {
                System.out.println("graph");
            }
        }
    }

    static boolean isConnected(int N, List<Integer>[] adj) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(1);
        visited[1] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adj[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        // 방문한 정점의 수가 전체 정점 수 N과 같으면 연결된 그래프
        return count == N;
    }
}