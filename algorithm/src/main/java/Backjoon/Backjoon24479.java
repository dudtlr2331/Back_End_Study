package algorithm.src.main.java.Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Backjoon24479 {
    static ArrayList<Integer>[] adj; // 인접 리스트
    static int[] order;              // 방문 순서를 저장할 배열
    static boolean[] visited;        // 방문 체크 배열
    static int count = 1;            // 방문 순서 카운트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 1. 그래프 간선 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u); // 무방향 그래프
        }

        // 2. 오름차순 방문을 위해 각 리스트 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        // 3. DFS 실행
        dfs(R);

        // 4. 각 정점의 방문 순서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;      // 현재 노드 방문 처리
        order[node] = count++;     // 방문 순서 기록

        for (int next : adj[node]) {
            if (!visited[next]) {  // 방문하지 않은 인접 노드가 있다면
                dfs(next);         // 재귀 호출 (깊게 탐색)
            }
        }
    }
}
