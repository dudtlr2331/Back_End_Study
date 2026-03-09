package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        long[] lines = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            if (lines[i] > max) max = lines[i]; // 가장 긴 랜선의 길이를 찾음
        }

        // 이분 탐색 범위 설정
        // 0으로 나누는 것을 방지하기 위해 low는 1부터, high는 가장 긴 랜선 길이까지
        long low = 1;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2; // 자를 랜선의 단위 길이
            long count = 0;

            // 모든 랜선을 mid 길이로 잘랐을 때 나오는 개수의 합 계산
            for (long line : lines) {
                count += (line / mid);
            }

            // 개수가 N보다 크거나 같다면 (더 길게 잘라도 되는지 확인)
            if (count >= N) {
                result = mid; // 현재 길이를 저장
                low = mid + 1;
            } else {
                // 개수가 부족하면 더 짧게 잘라야 함
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}