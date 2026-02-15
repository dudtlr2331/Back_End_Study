package Backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon1260 {

    static int[][] graph; // 그래프 연결 상태 (1이면 연결, 0이면 끊김)
    static boolean[] visited; // 방문 했는지 체크 (true/false)
    static int N, M, V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        V = sc.nextInt(); // 탐색을 시작할 정점 번호

        // 인덱스를 1부터 N까지 편하게 쓰기 위해 크기를 N+1로 잡음
        graph = new int[N+1][N+1];

        // 간선 연결 정보 입력
        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 양방향 연결이므로 둘 다 1로 표시
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 1. DFS 실행
        visited = new boolean[N+1]; // 방문 기록 초기화
        dfs(V);

        System.out.println(); // 줄 바꿈

        // 2. BFS 실행
        visited = new boolean[N+1]; // 방문 기록 다시 초기화 (중요!)
        bfs(V);
    }

    // 깊이 우선 탐색 (재귀 사용)
    public static void dfs(int node) {
        visited[node] = true;       // 현재 노드 방문 처리
        System.out.print(node + " ");

        // 현재 노드와 연결된 다른 노드들을 찾음 (작은 번호부터)
        for(int i=1; i<=N; i++) {
            // 연결되어 있고(1), 아직 안 가본 곳(!visited)이라면?
            if(graph[node][i] == 1 && !visited[i]) {
                dfs(i); // 더 깊이 들어감 (재귀)
            }
        }
    }

    // 너비 우선 탐색 (큐 사용)
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);       // 시작점을 큐에 넣고
        visited[start] = true; // 방문 처리

        while(!q.isEmpty()) {
            int node = q.poll(); // 큐에서 하나 꺼냄
            System.out.print(node + " ");

            // 꺼낸 노드와 연결된 친구들을 모두 큐에 담음
            for(int i=1; i<=N; i++) {
                if(graph[node][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}