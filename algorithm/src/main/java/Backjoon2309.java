import java.util.*;

public class Backjoon2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        int sum = 0;

        // 1. 9명의 키를 입력받으며 전체 합을 구함
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }

        // 2. 오름차순 출력을 위해 미리 정렬
        Arrays.sort(heights);

        int fake1 = -1, fake2 = -1;

        // 3. 이중 포문으로 가짜 난쟁이 2명을 찾음
        // 전체 합 - (난쟁이 i + 난쟁이 j) == 100 인 경우를 찾기
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if (fake1 != -1) break; // 가짜를 찾았다면 바깥쪽 루프도 종료
        }

        // 4. 가짜 2명을 제외하고 출력
        for (int i = 0; i < 9; i++) {
            if (i == fake1 || i == fake2) continue;
            System.out.println(heights[i]);
        }

        sc.close();
    }
}