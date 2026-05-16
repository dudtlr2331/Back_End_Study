package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        int strLen = str.length();
        int bombLen = bomb.length();

        // 스택 역할을 할 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strLen; i++) {
            // 1. 문자를 하나씩 쌓는다
            sb.append(str.charAt(i));

            // 2. 현재 쌓인 문자열의 길이가 폭발 문자열보다 길거나 같아지면 체크 시작
            if (sb.length() >= bombLen) {
                boolean isBomb = true;

                // 뒤에서부터 폭발 문자열과 일치하는지 확인
                for (int j = 0; j < bombLen; j++) {
                    char sbChar = sb.charAt(sb.length() - bombLen + j);
                    char bombChar = bomb.charAt(j);

                    if (sbChar != bombChar) {
                        isBomb = false;
                        break;
                    }
                }

                // 3. 폭발 문자열과 일치한다면 그만큼 자른다 (폭발)
                if (isBomb) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        // 4. 결과 출력
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}