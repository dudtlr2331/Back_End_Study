package day3;

import java.util.Arrays;

public class St4 {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 +1);

    }

    public static void main(String[] args) {
        St4 st1 = new St4();
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {1, 3, 5};
        int[] answer = st1.solution(arr, 1, 2);
        for(int i : answer) {
            System.out.println(i);
        }
    }
}
