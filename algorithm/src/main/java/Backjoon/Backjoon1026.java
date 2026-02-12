package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Backjoon1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        // B는 내림차순 정렬을 위해 Integer 객체 배열로 선언
        Integer[] B = new Integer[N];

        // A 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 1. A는 오름차순 정렬
        Arrays.sort(A);

        // 2. B는 내림차순 정렬
        Arrays.sort(B, Collections.reverseOrder());

        // 3. 작은 값 * 큰 값 연산 후 합산
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        System.out.println(S);
    }
}