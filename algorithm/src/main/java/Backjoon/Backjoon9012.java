package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            System.out.println(solve(br.readLine()));
        }
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 1. 여는 괄호 '('는 스택에 넣습니다.
            if (c == '(') {
                stack.push(c);
            }
            // 2. 닫는 괄호 ')'가 나왔을 때
            else {
                // 스택이 비어있다면 짝을 맞출 '('가 없는 것이므로 NO
                if (stack.isEmpty()) {
                    return "NO";
                }
                // 짝이 맞는 '('를 스택에서 제거합니다.
                stack.pop();
            }
        }

        // 3. 모든 검사가 끝난 후 스택이 비어있어야 YES, 남은게 있다면 NO
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
