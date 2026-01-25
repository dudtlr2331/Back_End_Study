package algorithm.src.main;

import java.util.*;

public class BFSExample {
    // 그래프 연결 상태를 저장할 인접 리스트
    static ArrayList<Integer>[] graph;
    // 방문 여부를 기록할 배열
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 6; // 노드의 개수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 간선 연결 (예시 데이터)
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(3, 6);

        System.out.print("BFS 탐색 순서: ");
        bfs(1); // 1번 노드부터 탐색 시작
    }

    // 간선 추가 (무방향 그래프 기준)
    static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    // BFS 구현
    static void bfs(int start) {
        // 큐 생성 및 시작 노드 삽입
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            // 큐에서 노드를 하나 꺼냄
            int node = queue.poll();
            System.out.print(node + " ");

            // 현재 노드와 연결된 모든 노드를 확인
            for (int next : graph[node]) {
                // 아직 방문하지 않은 노드라면 큐에 넣고 방문 처리
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}