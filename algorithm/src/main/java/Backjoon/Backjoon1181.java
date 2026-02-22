package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Backjoon1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // Arrays.sort와 Comparator를 사용한 사용자 정의 정렬
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 1. 길이가 다르면 길이 기준 오름차순
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                // 2. 길이가 같으면 사전 순으로 비교
                return s1.compareTo(s2);
            }
        });

        // 결과 출력 (중복 제거 포함)
        StringBuilder sb = new StringBuilder();
        if (N > 0) {
            sb.append(words[0]).append("\n");
            for (int i = 1; i < N; i++) {
                // 이전 단어와 다를 때만 출력 (중복 제거)
                if (!words[i].equals(words[i - 1])) {
                    sb.append(words[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}