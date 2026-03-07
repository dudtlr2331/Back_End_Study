package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 기준이 되는 N개의 숫자 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 이분 탐색을 위해 반드시 정렬 수행 (O(N log N))
        Arrays.sort(arr);

        // 3. 찾고 싶은 M개의 숫자 입력 및 탐색
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 이분 탐색 수행
            if (binarySearch(arr, target)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    // 이분 탐색 메서드
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return true; // 찾았을 때
            } else if (arr[mid] > target) {
                high = mid - 1; // 타겟이 중간값보다 작으면 왼쪽 탐색
            } else {
                low = mid + 1;  // 타겟이 중간값보다 크면 오른쪽 탐색
            }
        }
        return false; // 끝내 못 찾았을 때
    }
}