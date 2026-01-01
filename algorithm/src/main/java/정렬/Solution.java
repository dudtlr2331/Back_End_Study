package 정렬;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;

            // 부분 배열 생성
            int[] temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp); // 정렬

            answer[i] = temp[k]; // k번째 요소
        }

        return answer;
    }
}
