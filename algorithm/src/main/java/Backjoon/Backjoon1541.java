package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. '-'를 기준으로 문자열을 분리
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        int result = Integer.MAX_VALUE; // 초기값 설정

        while (subtraction.hasMoreTokens()) {
            int tempSum = 0;

            // 2. 분리된 각 그룹 내의 '+' 연산들을 모두 수행
            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
            while (addition.hasMoreTokens()) {
                tempSum += Integer.parseInt(addition.nextToken());
            }

            // 3. 첫 번째 뭉치는 결과값에 더해주고, 그 뒤부터는 계속 빼줌
            if (result == Integer.MAX_VALUE) {
                result = tempSum;
            } else {
                result -= tempSum;
            }
        }

        System.out.println(result);
    }
}