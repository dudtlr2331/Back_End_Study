package algorithm.src.main.java.Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.io));
        
        // 1. 파일의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 패턴 입력 (예: a*d)
        String pattern = br.readLine();
        
        // 3. 별표(*)를 기준으로 앞부분과 뒷부분 나누기
        int starIndex = pattern.indexOf('*');
        String front = pattern.substring(0, starIndex); // * 앞부분
        String back = pattern.substring(starIndex + 1); // * 뒷부분
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            
            // [중요 예외 처리]
            // 파일 이름의 길이가 패턴의 고정된 문자(앞부분 + 뒷부분) 길이보다 짧으면 불가능
            // 예: 패턴이 a*b (길이 2)인데 파일명이 a (길이 1)인 경우 방지
            if (fileName.length() < front.length() + back.length()) {
                sb.append("NE").append("\n");
                continue;
            }
            
            // 4. 앞부분과 뒷부분이 일치하는지 확인
            if (fileName.startsWith(front) && fileName.endsWith(back)) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
