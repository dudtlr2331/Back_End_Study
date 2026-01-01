package day2;

import java.util.Arrays;

public class St3 {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }

    public static void main(String[] args) {
        St3 st1 = new St3();

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

        System.out.println(st1.solution(arr1));
        System.out.println(st1.solution(arr2));

        System.out.println(100000 / 10);
    }
}
