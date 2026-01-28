package algorithm.src.main.java.Backjoon;

import java.util.Scanner;

public class Backjoon1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 선수의 수 입력
        int N = sc.nextInt();

        // 2. 알파벳 소문자 'a'-'z' 빈도를 저장할 배열 (크기 26)
        int[] counts = new int[26];

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            // 성의 첫 글자를 가져와서 해당 인덱스 증가
            char firstChar = name.charAt(0);
            counts[firstChar - 'a']++;
        }

        // 3. 5명 이상인 성의 첫 글자 찾기
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] >= 5) {
                // 인덱스를 다시 문자로 변환하여 추가
                result.append((char) (i + 'a'));
            }
        }

        // 4. 결과 출력
        if (result.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(result.toString());
        }
    }
}