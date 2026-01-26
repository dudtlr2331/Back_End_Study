package algorithm.src.main.java;

import java.util.*;

public class Graph {
    static ArrayList<Integer>[] adjList; // 인접 리스트
    static boolean[] visited;           // 방문 체크 배열

    public static void main(String[] args) {
        int nodes = 5; // 노드 개수
        adjList = new ArrayList[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프 간선 추가 (예시: 1-2, 1-3, 2-4, 3-5)
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);

        // 1. DFS 탐색 시작
        System.out.print("DFS 순서: ");
        visited = new boolean[nodes + 1];
        dfs(1);
        System.out.println();

        // 2. BFS 탐색 시작
        System.out.print("BFS 순서: ");
        visited = new boolean[nodes + 1];
        bfs(1);
    }

    // 간선 추가 (무향 그래프 기준)
    static void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    // DFS 구현 (재귀)
    static void dfs(int node) {
        visited[node] = true; // 방문 처리
        System.out.print(node + " ");

        for (int next : adjList[node]) {
            if (!visited[next]) {
                dfs(next); // 깊게 파고들기
            }
        }
    }

    // BFS 구현 (큐)
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 시작 노드 방문 처리

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 꺼내기
            System.out.print(node + " ");

            for (int next : adjList[node]) {
                if (!visited[next]) {
                    visited[next] = true; // 방문 표시 후
                    queue.add(next);      // 큐에 삽입 (넓게 퍼지기)
                }
            }
        }
    }
}
