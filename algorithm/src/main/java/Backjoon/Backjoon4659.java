package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon4659 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String password = sc.next();
            if (password.equals("end")) break; // "end" 입력 시 종료

            if (isValid(password)) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
    }

    // 비밀번호가 유효한지 검사하는 함수
    public static boolean isValid(String s) {
        boolean hasVowel = false; // 모음 포함 여부
        int vowelCount = 0;       // 연속된 모음 개수
        int consonantCount = 0;   // 연속된 자음 개수

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            boolean isCurrVowel = isVowel(curr);

            // 1. 모음 포함 여부 체크
            if (isCurrVowel) hasVowel = true;

            // 2. 연속 3개 (모음/자음) 체크
            if (isCurrVowel) {
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }
            if (vowelCount >= 3 || consonantCount >= 3) return false;

            // 3. 같은 글자 연속 2번 체크 (ee, oo 제외)
            if (i > 0) {
                char prev = s.charAt(i - 1);
                if (curr == prev) {
                    if (curr != 'e' && curr != 'o') return false;
                }
            }
        }

        // 최종적으로 모음이 하나라도 있어야 함
        return hasVowel;
    }

    // 모음인지 확인하는 보조 함수
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}