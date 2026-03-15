package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Backjoon1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        // 기본적으로 최소 힙(Min Heap)으로 동작하는 우선순위 큐
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 1. x가 0일 때: 가장 작은 값 출력 및 삭제
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n"); // 비어있으면 0 출력
                } else {
                    sb.append(minHeap.poll()).append("\n"); // 가장 작은 값 반환 및 삭제
                }
            } else {
                // 2. x가 자연수일 때: 배열에 추가
                minHeap.add(x);
            }
        }

        // 결과 한꺼번에 출력
        System.out.print(sb);
    }
}