package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Backjoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 큐 생성 (LinkedList를 구현체로 사용)
        Queue<Integer> q = new LinkedList<>();

        // 1. 1부터 N까지 카드 순서대로 넣기
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        // 2. 카드가 한 장 남을 때까지 반복
        while(q.size() > 1) {
            // 동작 1: 제일 위에 있는 카드를 버린다.
            q.poll();

            // 동작 2: 그 다음 위에 있는 카드를 제일 아래로 옮긴다.
            // (뽑아서 -> 다시 넣음)
            q.offer(q.poll());
        }

        // 3. 마지막 남은 카드 출력
        System.out.println(q.poll());
    }
}