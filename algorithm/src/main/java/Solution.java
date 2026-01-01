import java.util.Arrays;

class Solution {
    public String solution(String s) {
        // 1. 공백(" ")을 기준으로 문자열을 잘라 배열에 넣습니다.
        String[] strArr = s.split(" ");

        // 2. 숫자로 계산하기 위해 정수형(int) 배열을 선언합니다.
        int[] intArr = new int[strArr.length];

        // 3. 문자열 배열을 순회하며 정수로 변환해 저장합니다.
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        // 4. 배열을 오름차순으로 정렬합니다. (맨 앞이 최솟값, 맨 뒤가 최댓값이 됨)
        Arrays.sort(intArr);

        // 5. 최솟값과 최댓값을 공백을 두고 합쳐서 반환합니다.
        return intArr[0] + " " + intArr[intArr.length - 1];
    }
}