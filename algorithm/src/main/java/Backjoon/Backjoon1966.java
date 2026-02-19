package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되는지 궁금한 문서의 위치 (0부터 시작)

            // 문서 정보를 담을 큐 (LinkedList 사용)
            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // 1. 큐에 문서 넣기 {초기 위치, 중요도}
            for (int i = 0; i < N; i++) {
                // 배열로 {index, priority} 묶어서 저장
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0; // 인쇄된 순서

            // 2. 시뮬레이션 시작
            while (!q.isEmpty()) {

                // 가장 앞에 있는 문서를 꺼냄
                int[] current = q.poll();
                boolean isMax = true; // 현재 문서가 가장 중요한가?

                // 큐에 남아있는 문서들과 중요도 비교
                for (int[] doc : q) {
                    if (doc[1] > current[1]) { // 나보다 중요한 문서가 있다면?
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    // 현재 문서가 가장 중요함 -> 인쇄!
                    count++;

                    // 만약 이번에 인쇄한 문서가 우리가 찾던 M번째 문서라면?
                    if (current[0] == M) {
                        sb.append(count).append('\n');
                        break; // 다음 테스트 케이스로 넘어감
                    }
                } else {
                    // 나보다 중요한 문서가 있음 -> 다시 맨 뒤로 보냄
                    q.offer(current);
                }
            }
        }

        System.out.println(sb);
    }
}