import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        long[] dist = new long[N - 1]; // 도시 사이의 거리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        long[] cost = new long[N]; // 도시별 주유소 리터당 가격
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        // 2. 그리디 로직 수행
        long totalCost = 0;
        long minCost = cost[0]; // 현재까지 발견한 가장 저렴한 주유 가격 (첫 도시 가격으로 초기화)

        for (int i = 0; i < N - 1; i++) {
            /*
             * 현재 도시의 주유 가격이 이전까지의 최소 가격보다 싸다면 갱신합니다.
             * 더 비싸다면, 이전의 최소 가격으로 현재 구간을 이동한다고 계산합니다.
             */
            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            // (최소 주유 가격 * 이동할 거리)를 총 비용에 더함
            totalCost += (minCost * dist[i]);
        }

        // 3. 결과 출력
        System.out.println(totalCost);
    }
}