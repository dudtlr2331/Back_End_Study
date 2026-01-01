package 정렬;

import java.util.Arrays;
import java.util.Comparator;

public class S2 {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 정렬 기준을 설정하여 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // 두 문자열을 이어붙여 비교
                return (y + x).compareTo(x + y);
            }
        });

        // 정렬된 숫자를 이어붙여 결과 생성
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNumbers) {
            largestNumber.append(num);
        }

        // 0만 있는 경우 처리
        if (largestNumber.charAt(0) == '0') {
            return "0";
        }

        return largestNumber.toString();
    }
}
