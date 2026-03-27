package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 중복을 허용하지 않고 삽입/삭제가 빠른 HashSet 사용
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                set.add(name); // 출근하면 추가
            } else {
                set.remove(name); // 퇴근하면 삭제
            }
        }

        // 2. 현재 회사에 있는 사람들을 리스트로 변환하여 정렬
        List<String> list = new ArrayList<>(set);

        // 사전 순의 역순(Z-A)으로 정렬
        Collections.sort(list, Collections.reverseOrder());

        // 3. StringBuilder를 사용하여 한꺼번에 출력
        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}