import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수

        int[] ingredients = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 정렬 (투 포인터를 사용하기 위한 필수 단계)
        Arrays.sort(ingredients);

        int count = 0;
        int i = 0;     // start 포인터
        int j = N - 1; // end 포인터

        // 3. 투 포인터 이동 로직
        while (i < j) {
            int sum = ingredients[i] + ingredients[j];

            if (sum == M) {
                count++;
                i++;
                j--;
            } else if (sum < M) {
                i++;
            } else { // sum > M
                j--;
            }
        }

        // 4. 결과 출력
        System.out.println(count);
    }
}