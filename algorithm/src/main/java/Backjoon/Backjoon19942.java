package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon19942 {
    static int N;
    static int mp, mg, ms, mv; // 목표 영양소
    static int[][] ingredients;
    static int minCost = Integer.MAX_VALUE;
    static String minPath = ""; // 사전 순 비교를 위한 경로 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mg = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        ingredients = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ingredients[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작: 인덱스 0부터 탐색
        dfs(0, 0, 0, 0, 0, 0, new ArrayList<>());

        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
            System.out.println(minPath);
        }
    }

    static void dfs(int idx, int p, int g, int s, int v, int cost, List<Integer> path) {
        // 현재 비용이 이미 최솟값보다 크면 더 이상 탐색할 필요 없음 (가지치기)
        if (cost >= minCost && minCost != Integer.MAX_VALUE) {
            // 비용이 같을 때 사전 순 비교를 위해 바로 리턴하지 않고 조건 확인 필요
            // 여기서는 아래에서 조건 만족 시 비교 로직을 넣음
        }

        // 모든 영양소 조건을 만족하는지 확인
        if (p >= mp && g >= mg && s >= ms && v >= mv) {
            if (cost < minCost) {
                minCost = cost;
                minPath = makePathString(path);
            } else if (cost == minCost) {
                String currentPath = makePathString(path);
                if (currentPath.compareTo(minPath) < 0) {
                    minPath = currentPath;
                }
            }
            return;
        }

        if (idx == N) return;

        // 1. 현재 식재료를 선택하는 경우
        path.add(idx + 1); // 식재료 번호는 1번부터
        dfs(idx + 1, p + ingredients[idx][0], g + ingredients[idx][1],
                s + ingredients[idx][2], v + ingredients[idx][3], cost + ingredients[idx][4], path);
        path.remove(path.size() - 1); // 백트래킹 (원상복구)

        // 2. 현재 식재료를 선택하지 않는 경우
        dfs(idx + 1, p, g, s, v, cost, path);
    }

    // 리스트에 담긴 식재료 번호들을 공백이 포함된 문자열로 변환
    static String makePathString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i : path) {
            sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }
}