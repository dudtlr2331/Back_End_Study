package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        // 1. 듣도 못한 사람을 HashSet에 저장 (빠른 검색용)
        HashSet<String> heard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            heard.add(br.readLine());
        }

        // 2. 보도 못한 사람을 입력받으며 교집합 찾기
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (heard.contains(name)) {
                result.add(name);
            }
        }

        // 3. 교집합 명단을 사전 순으로 정렬
        Collections.sort(result);

        // 4. 결과 출력 (StringBuilder 사용)
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}