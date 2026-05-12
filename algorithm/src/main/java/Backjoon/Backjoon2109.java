package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon2109 {
    static class Lecture implements Comparable<Lecture> {
        int p, d;

        Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }

        // 마감일 기준 내림차순 정렬
        @Override
        public int compareTo(Lecture o) {
            return o.d - this.d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Lecture> list = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Lecture(p, d));
            maxDay = Math.max(maxDay, d); // 가장 늦은 마감일 찾기
        }

        // 1. 마감일 기준으로 내림차순 정렬
        Collections.sort(list);

        // 2. 비용을 담을 우선순위 큐 (내림차순 정렬 = 최대 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int totalSum = 0;
        int lectureIdx = 0;

        // 3. 가장 늦은 날짜부터 1일까지 거꾸로 탐색
        for (int i = maxDay; i >= 1; i--) {
            // 현재 날짜(i)에 강연할 수 있는(마감일이 i 이상인) 강연들을 큐에 삽입
            while (lectureIdx < n && list.get(lectureIdx).d >= i) {
                pq.add(list.get(lectureIdx).p);
                lectureIdx++;
            }

            // 큐가 비어있지 않다면, 그중 가장 비용이 높은 강연 하나를 선택
            if (!pq.isEmpty()) {
                totalSum += pq.poll();
            }
        }

        System.out.println(totalSum);
    }
}