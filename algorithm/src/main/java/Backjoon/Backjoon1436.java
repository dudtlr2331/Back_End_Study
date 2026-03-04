package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon1436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666; // 가장 작은 종말의 수부터 시작
        int count = 1; // 현재 몇 번째 종말의 수인지 기록

        // count가 N이 될 때까지 무한 반복
        while (count != N) {
            num++; // 숫자를 1씩 키우며 검사

            // 숫자를 문자열로 바꾼 뒤 "666"이 들어있는지 확인
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }

        System.out.println(num);
    }
}