package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Backjoon1037 {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입력을 위해 BufferedReader를 사용합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 진짜 약수의 개수를 입력받습니다.
        int count = Integer.parseInt(br.readLine());

        // 3. 최솟값과 최댓값을 찾기 위한 변수를 초기화합니다.
        // 입력되는 약수는 2 이상 1,000,000 이하입니다.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 4. 한 줄에 들어오는 약수들을 공백 단위로 분리합니다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 현재 숫자가 기존 최댓값보다 크면 갱신
            if (num > max) {
                max = num;
            }
            // 현재 숫자가 기존 최솟값보다 작으면 갱신
            if (num < min) {
                min = num;
            }
        }

        // 5. 가장 작은 약수와 가장 큰 약수를 곱하면 원래의 수 N이 나옵니다.
        // 결과값이 int 범위를 초과할 수 있으므로 long으로 계산하여 출력합니다.
        System.out.println((long) min * max);
    }
}