package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop(); // 최근 숫자 제거 (FILO)
            } else {
                stack.push(num);
            }
        }

        long sum = 0;
        for (int n : stack) {
            sum += n;
        }
        System.out.println(sum);
    }
}
