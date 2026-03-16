package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Backjoon11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 절댓값 힙 구현을 위한 커스텀 정렬 기준 설정
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);

            // 1. 절댓값이 같으면 실제 값이 작은 것을 우선시
            if (firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            }
            // 2. 절댓값이 다르면 절댓값이 작은 것을 우선시
            return firstAbs - secondAbs;
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (absHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(absHeap.poll()).append("\n");
                }
            } else {
                absHeap.add(x);
            }
        }
        System.out.print(sb);
    }
}