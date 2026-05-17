package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon1781 {
    static class Problem implements Comparable<Problem> {
        int deadline, cupNoodles;

        Problem(int deadline, int cupNoodles) {
            this.deadline = deadline;
            this.cupNoodles = cupNoodles;
        }

        // 데드라인 기준 오름차순 정렬, 데드라인이 같다면 컵라면 많은 순
        @Override
        public int compareTo(Problem o) {
            if (this.deadline == o.deadline) {
                return o.cupNoodles - this.cupNoodles;
            }
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Problem> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Problem(d, c));
        }

        // 1. 데드라인 기준 오름차순 정렬
        Collections.sort(list);

        // 2. 선택한 문제의 컵라면 수를 담을 최소 힙 (오름차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3. 순차 탐색하며 그리디하게 교체
        for (Problem p : list) {
            if (pq.size() < p.deadline) {
                // 현재 데드라인보다 선택한 문제 수가 적으면 일단 추가
                pq.add(p.cupNoodles);
            } else if (!pq.isEmpty() && pq.peek() < p.cupNoodles) {
                // 이미 꽉 찼다면, 기존 선택 중 가장 보상이 적은 문제를 버리고 현재 문제 선택
                pq.poll();
                pq.add(p.cupNoodles);
            }
        }

        // 4. 큐에 남은 모든 컵라면 수 합산 (결과가 클 수 있으므로 long)
        long totalCupNoodles = 0;
        while (!pq.isEmpty()) {
            totalCupNoodles += pq.poll();
        }

        System.out.println(totalCupNoodles);
    }
}