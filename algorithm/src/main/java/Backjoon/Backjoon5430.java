package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            // 입력 [1,2,3,4] 에서 []를 제거하고 ,를 기준으로 분리
            String input = br.readLine();
            Deque<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");

            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            processAC(command, deque);
        }
        System.out.print(sb);
    }

    static void processAC(String command, Deque<Integer> deque) {
        boolean isRight = true; // 현재 방향 (true: 정방향, false: 역방향)

        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight; // 방향 반전
            } else {
                // D 연산: 비어있으면 에러
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }

                if (isRight) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        // 출력 형식 맞추기
        makeString(deque, isRight);
    }

    static void makeString(Deque<Integer> deque, boolean isRight) {
        sb.append("[");
        while (!deque.isEmpty()) {
            // 방향에 따라 요소를 꺼냄
            sb.append(isRight ? deque.pollFirst() : deque.pollLast());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
    }
}