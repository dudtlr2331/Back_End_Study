package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon1325 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // B를 해킹하면 A도 해킹되므로, B -> A 방향으로 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }

        result = new int[N + 1];
        int maxVal = 0;

        // 모든 컴퓨터에 대해 BFS 수행
        for (int i = 1; i <= N; i++) {
            result[i] = bfs(i);
            maxVal = Math.max(maxVal, result[i]);
        }

        // 최대값을 가진 컴퓨터 번호 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(start);
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : adj[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}