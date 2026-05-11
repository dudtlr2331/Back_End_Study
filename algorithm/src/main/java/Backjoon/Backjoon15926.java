package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon15926 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        // 괄호의 짝이 맞는지 확인할 배열
        boolean[] valid = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // 열린 괄호는 인덱스를 스택에 저장
                stack.push(i);
            } else {
                // 닫힌 괄호일 때 짝이 맞는 열린 괄호가 있다면
                if (!stack.isEmpty()) {
                    int openIdx = stack.pop();
                    // 두 위치 모두 올바른 괄호 구간임을 표시
                    valid[openIdx] = true;
                    valid[i] = true;
                }
            }
        }

        // 체크된 배열에서 가장 길게 연속된 true 구간 찾기
        int maxLen = 0;
        int currentLen = 0;
        for (int i = 0; i < n; i++) {
            if (valid[i]) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;
            }
        }

        System.out.println(maxLen);
    }
}