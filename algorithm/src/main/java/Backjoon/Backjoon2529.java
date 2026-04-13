package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon2529 {
    static int K;
    static char[] signs;
    static boolean[] visited = new boolean[10];
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        signs = new char[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        // 백트래킹 시작: 빈 문자열부터 숫자를 하나씩 붙여나감
        dfs("", 0);

        // 결과 리스트 정렬 (이미 순서대로 담기지만 명확성을 위해 정렬)
        Collections.sort(result);

        // 최댓값과 최솟값 출력
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    static void dfs(String num, int depth) {
        // k+1개의 숫자를 모두 뽑았을 때
        if (depth == K + 1) {
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                // 첫 번째 숫자는 제약 없이 넣고, 그 다음부터는 부등호 체크
                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                    visited[i] = true;
                    dfs(num + i, depth + 1);
                    visited[i] = false; // 백트래킹: 원상복구
                }
            }
        }
    }

    // 부등호 성립 여부 확인 함수
    static boolean check(int a, int b, char sign) {
        if (sign == '<') return a < b;
        if (sign == '>') return a > b;
        return false;
    }
}
