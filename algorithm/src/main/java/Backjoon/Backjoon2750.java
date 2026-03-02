package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Backjoon2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 수의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 2. N개의 수를 배열에 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 3. 자바 내장 정렬 알고리즘 사용 (Dual-Pivot Quicksort)
        Arrays.sort(arr);

        // 4. 결과 출력 (출력 양이 많을 수 있으므로 StringBuilder 권장)
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value).append('\n');
        }

        System.out.print(sb);
    }
}