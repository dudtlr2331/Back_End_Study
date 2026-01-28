package algorithm.src.main.java.Backjoon;

import java.util.*;
import java.io.*;

public class backjoon2606 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        m = Integer.parseInt(br.readLine()); // 연결 수

        // 그래프 초기화 (1번 인덱스부터 쓰기 위해 n+1)
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            // 양방향 연결
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        int count = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++; // 감염된 컴퓨터 카운트 증가
                }
            }
        }
        return count;
    }
}
