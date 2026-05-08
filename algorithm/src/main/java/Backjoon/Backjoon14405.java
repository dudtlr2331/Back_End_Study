package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon14405 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // "pi", "ka", "chu"를 정규표현식 그룹으로 묶어 빈 문자열로 치환
        // 만약 단어가 사라지면서 새로운 pi가 생기는걸 방지하려면
        // 숫자가 아닌 다른 문자 하나(예: " ")로 치환 후 검사하는게 더 확실합니다.
        String result = S.replaceAll("pi|ka|chu", "");

        // 결과 문자열의 길이가 0이면 피카츄가 모두 발음할 수 있는 단어
        if (result.length() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}