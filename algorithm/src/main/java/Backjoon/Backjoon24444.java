package algorithm.src.main.java.Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon24444 {
    static ArrayList<Integer>[] adj;
    static int[] order;
    static boolean[] visited;
    static int count = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 1. 그래프 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        // 2. 오름차순 방문을 위한 정렬 (이 부분이 빠지면 틀립니다)
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        // 3. BFS 실행
        bfs(R);

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 시작 노드 방문 처리

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[node] = count++; // 방문 순환 기록

            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true; // 큐에 넣기 전 즉시 방문 처리
                    queue.add(next);
                }
            }
        }
    }
}
