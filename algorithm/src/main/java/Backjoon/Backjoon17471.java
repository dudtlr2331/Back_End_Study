package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon17471 {
    static int N;
    static int[] populations;
    static List<Integer>[] adj;
    static boolean[] selected;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        populations = new int[N + 1];
        adj = new ArrayList[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        selected = new boolean[N + 1];
        // 1. 구역을 두 그룹으로 나누는 조합 탐색 (subset)
        divide(1);

        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }

    static void divide(int idx) {
        if (idx == N + 1) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i]) groupA.add(i);
                else groupB.add(i);
            }

            // 한 그룹에 최소 한 개의 구역은 있어야 함
            if (groupA.isEmpty() || groupB.isEmpty()) return;

            // 2. 각 그룹이 내부적으로 연결되어 있는지 확인
            if (isConnected(groupA) && isConnected(groupB)) {
                // 3. 인구 차이 계산
                calculateDifference(groupA, groupB);
            }
            return;
        }

        selected[idx] = true;
        divide(idx + 1);
        selected[idx] = false;
        divide(idx + 1);
    }

    static boolean isConnected(List<Integer> group) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(group.get(0));
        visited[group.get(0)] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : adj[now]) {
                // 같은 그룹에 속해 있고, 아직 방문하지 않은 경우
                if (group.contains(next) && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }

    static void calculateDifference(List<Integer> groupA, List<Integer> groupB) {
        int sumA = 0, sumB = 0;
        for (int i : groupA) sumA += populations[i];
        for (int i : groupB) sumB += populations[i];
        minDifference = Math.min(minDifference, Math.abs(sumA - sumB));
    }
}