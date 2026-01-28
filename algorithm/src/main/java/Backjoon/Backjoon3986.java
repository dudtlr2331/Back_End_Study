package algorithm.src.main.java.Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon3986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isGoodWord(String word) {
        // 홀수 개의 문자로 이루어진 단어는 절대 쌍을 맞출 수 없음
        if (word.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            // 스택이 비어있지 않고, 맨 위 글자가 현재 글자와 같다면 (쌍이 맞으면)
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 쌍을 제거
            } else {
                stack.push(c); // 쌍이 안 맞으면 스택에 추가
            }
        }

        // 모든 쌍이 맞아서 스택이 비어있어야 '좋은 단어'
        return stack.isEmpty();
    }
}