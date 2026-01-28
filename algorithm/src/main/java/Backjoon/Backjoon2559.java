package algorithm.src.main.java.Backjoon;

import java.util.Scanner;

public class Backjoon2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 전체 날짜 수, K: 합을 구해야 하는 연속 날짜 수
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] temperatures = new int[N];
        for (int i = 0; i < N; i++) {
            temperatures[i] = sc.nextInt();
        }

        // 1. 처음 K일 동안의 온도의 합을 구함 (첫 번째 윈도우)
        int currentSum = 0;
        for (int i = 0; i < K; i++) {
            currentSum += temperatures[i];
        }

        // 2. 초기 합을 최댓값으로 설정
        int maxSum = currentSum;

        // 3. 슬라이딩 윈도우 시작
        // i는 새로 추가될 원소의 인덱스, (i - K)는 빠질 원소의 인덱스
        for (int i = K; i < N; i++) {
            currentSum = currentSum + temperatures[i] - temperatures[i - K];

            // 더 큰 값이 나오면 갱신
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        // 결과 출력
        System.out.println(maxSum);
    }
}