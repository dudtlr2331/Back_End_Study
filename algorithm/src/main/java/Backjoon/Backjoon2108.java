package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] count = new int[8001]; // -4000 ~ 4000 범위를 수용하는 카운팅 배열
        long sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            // 음수 인덱스 처리를 위해 +4000 (0이 -4000, 4000이 0, 8000이 4000)
            count[arr[i] + 4000]++;
        }

        // 1. 산술평균
        System.out.println(Math.round((double) sum / N));

        // 2. 중앙값 (정렬 후 중간 인덱스)
        Arrays.sort(arr);
        System.out.println(arr[N / 2]);

        // 3. 최빈값
        int maxFreq = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
            }
        }

        ArrayList<Integer> modeList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxFreq) {
                modeList.add(i - 4000); // 다시 원래 숫자로 복원
            }
        }

        if (modeList.size() > 1) {
            // 여러 개면 두 번째로 작은 값 (이미 i가 증가하며 담겼으므로 정렬된 상태)
            System.out.println(modeList.get(1));
        } else {
            System.out.println(modeList.get(0));
        }

        // 4. 범위
        System.out.println(arr[N - 1] - arr[0]);
    }
}