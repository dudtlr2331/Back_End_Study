package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon1202 {
    // 보석 정보를 담을 클래스
    static class Gem implements Comparable<Gem> {
        int weight, value;

        Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        // 무게 기준 오름차순 정렬
        @Override
        public int compareTo(Gem o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        List<Gem> gems = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gems.add(new Gem(w, v));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 1. 보석을 무게 기준으로 오름차순 정렬
        Collections.sort(gems);

        // 2. 가방을 수용 무게 기준으로 오름차순 정렬
        Arrays.sort(bags);

        // 3. 보석의 가격을 내림차순(최대 힙)으로 관리할 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long totalPrice = 0;
        int gemIdx = 0;

        // 4. 작은 가방부터 하나씩 확인
        for (int i = 0; i < K; i++) {
            int currentBagLimit = bags[i];

            // 현재 가방의 무게 제한 이하인 보석들을 모두 큐에 삽입
            // gemIdx를 초기화하지 않고 유지하므로 보석 리스트를 딱 한 번만 순회함 (O(N))
            while (gemIdx < N && gems.get(gemIdx).weight <= currentBagLimit) {
                pq.add(gems.get(gemIdx).value);
                gemIdx++;
            }

            // 큐가 비어있지 않다면 현재 가방에 담을 수 있는 가장 비싼 보석을 꺼냄
            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        System.out.println(totalPrice);
    }
}