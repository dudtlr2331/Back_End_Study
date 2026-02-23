package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backjoon2870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<BigInteger> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            // 1. 숫자가 아닌 모든 문자를 공백으로 치환
            // 정규표현식 [a-z]를 사용하여 문자를 구분자로 만듭니다.
            String[] splitArray = line.split("[a-z]");

            for (String s : splitArray) {
                // 2. 빈 문자열이 아니면 숫자로 변환하여 리스트에 추가
                if (!s.isEmpty()) {
                    numbers.add(new BigInteger(s));
                }
            }
        }

        // 3. 오름차순 정렬
        Collections.sort(numbers);

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (BigInteger num : numbers) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}