package algorithm.src.main.java.Backjoon;

import java.util.*;

public class Backjoon2979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 요금 정보 입력 받기 (1대, 2대, 3대일 때의 한 대당 요금)
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        // 2. 시간대별 트럭 대수를 기록할 배열 (시간 범위 1~100)
        int[] timeLine = new int[101];

        // 3. 3대 트럭의 입차, 출차 시간 입력 받기
        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            // 핵심: 입차 시간부터 '출차 시간 전'까지 트럭 대수를 1씩 더함
            for (int t = start; t < end; t++) {
                timeLine[t]++;
            }
        }

        // 4. 전체 요금 계산
        int totalFare = 0;
        for (int i = 1; i < 101; i++) {
            if (timeLine[i] == 1) {
                totalFare += A;           // 1대 주차된 시간: A원
            } else if (timeLine[i] == 2) {
                totalFare += B * 2;       // 2대 주차된 시간: B원 * 2대
            } else if (timeLine[i] == 3) {
                totalFare += C * 3;       // 3대 주차된 시간: C원 * 3대
            }
        }

        System.out.println(totalFare);
        sc.close();
    }
}