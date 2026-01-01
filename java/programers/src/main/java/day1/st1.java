package day1;

//import java.util.Arrays;

public class st1 {

    public static int solution(int[] array) {
        int[] count = new int[1000];

        for (int num : array) {
            count[num]++;
        }

        int mode = count[0];
        int answer = 0;

        for (int i = 1; i < count.length; i++) {
            if (mode < count[i]) {
                mode = count[i];
                answer = i;
            } else if (mode == count[i]) {
                answer = -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 2, 3, 3, 3, 4})); // 3
//        System.out.println(solution(new int[]{1, 1, 2, 2}));       // -1
//        System.out.println(solution(new int[]{1}));                // 1
    }
}
