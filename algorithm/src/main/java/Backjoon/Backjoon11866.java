package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int K = Integer.parseInt(st.nextToken()); // 제거할 번째 수

        Queue<Integer> q = new LinkedList<>();

        // 1. 1부터 N까지 큐에 채우기
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<'); // 여는 괄호

        // 2. 큐에 사람이 1명 남을 때까지 반복
        while (q.size() > 1) {

            // K-1명은 앞에서 빼서 뒤로 보냄 (살려둠)
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            // K번째 사람은 제거 (결과에 추가)
            sb.append(q.poll()).append(", ");
        }

        // 3. 마지막 남은 한 명 처리 (쉼표 없이)
        sb.append(q.poll()).append('>'); // 닫는 괄호

        System.out.println(sb);
    }
}