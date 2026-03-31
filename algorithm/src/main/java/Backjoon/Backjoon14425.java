package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Backjoon14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 집합 S를 저장할 HashSet 생성
        HashSet<String> set = new HashSet<>();

        // 2. N개의 문자열을 HashSet에 저장 (중복 제거 및 빠른 검색 준비)
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        // 3. M개의 문자열을 읽으며 집합 S에 포함되어 있는지 확인
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                count++;
            }
        }

        // 4. 최종 결과 출력
        System.out.println(count);
    }
}