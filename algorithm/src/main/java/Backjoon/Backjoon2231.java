package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0; // 정답을 담을 변수 (생성자가 없으면 0을 출력해야 하므로 0으로 초기화)

        // 1부터 n 직전까지 모든 수를 다 검사해 봅니다.
        for (int i = 1; i < n; i++) {
            int number = i;
            int sum = i; // 분해합: 기본 숫자(i) + 각 자리수의 합

            // 각 자리수를 더하는 로직
            while (number > 0) {
                sum += number % 10; // 10으로 나눈 나머지(1의 자리)를 더함
                number /= 10;       // 10으로 나눠서 자리수를 하나 줄임
            }

            // 계산된 분해합(sum)이 입력받은 n과 같다면? 정답!
            if (sum == n) {
                result = i;
                break; // 가장 작은 생성자를 찾았으므로 즉시 반복문을 탈출합니다.
            }
        }

        System.out.println(result);
    }
}