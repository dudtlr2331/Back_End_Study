package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 전체 사람의 수

        // 사람들의 몸무게와 키를 저장할 2차원 배열 (N명, 2개의 데이터)
        int[][] person = new int[N][2];

        // 1. 입력받아서 배열에 저장하기
        for (int i = 0; i < N; i++) {
            // 한 줄에 공백을 기준으로 두 숫자가 들어오므로 쪼개줍니다.
            String[] input = br.readLine().split(" ");
            person[i][0] = Integer.parseInt(input[0]); // 몸무게
            person[i][1] = Integer.parseInt(input[1]); // 키
        }

        // 2. 브루트포스: 모든 사람을 서로 비교하기
        StringBuilder sb = new StringBuilder(); // 결과를 한 번에 모아서 출력하기 위함

        for (int i = 0; i < N; i++) {
            int rank = 1; // 일단 모든 사람의 기본 등수를 1등으로 시작합니다.

            for (int j = 0; j < N; j++) {
                // i는 기준이 되는 '나', j는 비교 대상인 '상대방'입니다.
                if (i == j) continue; // 나 자신과는 비교할 필요가 없으니 패스!

                // 만약 상대방(j)이 나(i)보다 몸무게도 무겁고 '그리고(&&)' 키도 크다면?
                if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                    rank++; // 내 위로 한 명이 더 있으니 등수가 1등수 밀려납니다.
                }
            }
            // 내부 반복문이 끝나면 내 최종 등수가 결정됩니다.
            sb.append(rank).append(" ");
        }

        // 최종적으로 모인 등수들을 한 줄에 출력
        System.out.println(sb.toString().trim());
    }
}