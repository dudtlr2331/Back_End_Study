package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        long M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이

        int[] trees = new int[N];
        long max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) max = trees[i]; // 나무 중 가장 높은 높이를 찾음
        }

        // 이분 탐색 범위 설정
        long low = 0;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2; // 절단기 높이 설정
            long sum = 0;

            // 설정한 높이(mid)로 나무들을 잘랐을 때 얻는 합계 계산
            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            // 자른 나무의 합이 필요한 양(M)보다 크거나 같다면
            if (sum >= M) {
                result = mid; // 일단 현재 높이를 저장하고
                low = mid + 1; // 더 높게 잘라도 되는지 확인 (최댓값 찾기)
            } else {
                // 나무가 부족하면 절단기 높이를 낮춰야 함
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}