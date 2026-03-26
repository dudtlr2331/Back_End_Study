package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Backjoon10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 상근이가 가진 카드 입력 받기
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 2. 확인할 카드들 입력 받기
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 3. HashSet의 contains는 O(1) 수준으로 매우 빠름
            if (set.contains(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        // 4. 결과 한 번에 출력
        System.out.println(sb.toString().trim());
    }
}