package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] result = new int[N]; // 정답(오큰수)을 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        // 1. 배열을 순회하며 오큰수 찾기
        for (int i = 0; i < N; i++) {
            /*
             * 스택이 비어있지 않고, 현재 숫자가 스택 top 인덱스의 숫자보다 크면
             * 스택에 있던 인덱스들의 오큰수는 현재 숫자가 됨
             */
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            // 현재 인덱스를 스택에 넣음
            stack.push(i);
        }

        // 2. 반복문이 끝난 후 스택에 남은 인덱스는 오큰수가 없는 것들
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        // 3. 결과 출력 (백만 건이므로 StringBuilder 필수)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}