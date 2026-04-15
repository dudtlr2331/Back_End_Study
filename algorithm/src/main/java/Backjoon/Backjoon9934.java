package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon9934 {
    static int K;
    static int[] nodes;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 처리
        K = Integer.parseInt(br.readLine()); // 트리의 깊이
        int nodeCount = (int) Math.pow(2, K) - 1; // 전체 노드 개수
        nodes = new int[nodeCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeCount; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 레벨별로 노드를 담을 리스트 초기화
        tree = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            tree[i] = new ArrayList<>();
        }

        // 3. 트리 복원 시작 (재귀)
        solve(0, nodeCount - 1, 0);

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int node : tree[i]) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    /**
     * @param start 탐색 범위 시작 인덱스
     * @param end   탐색 범위 끝 인덱스
     * @param depth 현재 트리의 깊이 (0부터 시작)
     */
    static void solve(int start, int end, int depth) {
        // 기저 사례: 깊이가 K에 도달하면 종료
        if (depth == K) return;

        // 중간 지점이 현재 서브트리의 루트 노드
        int mid = (start + end) / 2;

        // 해당 깊이 리스트에 노드 추가
        tree[depth].add(nodes[mid]);

        // 왼쪽 서브트리 (중간 기준 왼쪽 범위)
        solve(start, mid - 1, depth + 1);

        // 오른쪽 서브트리 (중간 기준 오른쪽 범위)
        solve(mid + 1, end, depth + 1);
    }
}