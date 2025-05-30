import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class ArrayEx03 {
    public static void main(String[] args) {
        // 배열의 초기화
        // 전통
        int[] arr1 = new int[]{0, 1, 2, 3, 4};
        int[] arr2 = {0, 1, 2, 3, 4};

        // 동적
        // Arrays.fill()
        // Random/ Math.random()
        // 입력
        // System.in
        // Scanner

        // 1000개의 임의의 값 입력
        // Random
        // 1 ~ 100 값에 선택해서 1000를 입력

        Random r = new Random(System.currentTimeMillis());
        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(100) + 1;
        }

        System.out.println(Arrays.toString(numbers));
    }
}
