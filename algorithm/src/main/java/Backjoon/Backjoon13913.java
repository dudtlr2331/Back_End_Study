package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon13913 {
    static int N, K;
    static int[] parent = new int[100001]; // 이전 위치 저장용
    static int[] time = new int[100001];   // 도달 시간 저장용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        bfs();

        // 경로 추적: K부터 역추적하여 Stack에 담기
        StringBuilder sb = new StringBuilder();
        sb.append(time[K]).append("\n");

        Stack<Integer> path = new Stack<>();
        int current = K;
        while (current != -1) {
            path.push(current);
            current = parent[current];
        }

        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        // 초기화: 방문하지 않은 곳은 -1, 시작점의 부모는 -1로 설정
        Arrays.fill(parent, -1);
        time[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) return;

            int[] nextPositions = {now - 1, now + 1, now * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && parent[next] == -1 && next != N) {
                    parent[next] = now;    // 어디서 왔는지 기록
                    time[next] = time[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}