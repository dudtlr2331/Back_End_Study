package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon12851 {
    static int N, K;
    static int[] time = new int[100001]; // 각 위치에 도달하는 최단 시간 저장
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            // 수빈이가 동생보다 앞서 있으면 뒤로 걷는 방법뿐임
            System.out.println((N - K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 1; // 시작 지점 (계산 편의를 위해 1초부터 시작, 결과에서 1 뺌)

        while (!q.isEmpty()) {
            int now = q.poll();

            // 현재 시간이 이미 찾은 최단 시간보다 크면 더 이상 탐색 불필요
            if (minTime < time[now]) continue;

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    if (minTime > time[now]) {
                        minTime = time[now]; // 처음 도달한 시간이 최단 시간
                        count = 1;
                    } else if (minTime == time[now]) {
                        count++; // 같은 최단 시간으로 도달한 경우 가짓수 추가
                    }
                }

                // 방문하지 않았거나, 다른 경로지만 같은 시간(최단 시간)에 도달한 경우
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    time[next] = time[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}