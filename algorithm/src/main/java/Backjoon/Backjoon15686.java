package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point1 {
    int r, c;
    Point1(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Backjoon15686 {
    static int N, M;
    static ArrayList<Point1> houses = new ArrayList<>();
    static ArrayList<Point1> chickens = new ArrayList<>();
    static boolean[] selected;
    static int minTotalDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    houses.add(new Point1(i, j));
                } else if (val == 2) {
                    chickens.add(new Point1(i, j));
                }
            }
        }

        selected = new boolean[chickens.size()];

        // 치킨집 중 M개를 고르는 조합 시작
        backtracking(0, 0);

        System.out.println(minTotalDistance);
    }

    // 백트래킹을 이용한 조합 구하기
    static void backtracking(int start, int count) {
        if (count == M) {
            calculateCityDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            backtracking(i + 1, count + 1);
            selected[i] = false; // 백트래킹 (원상복구)
        }
    }

    // 선택된 M개의 치킨집에 대한 도시의 치킨 거리 계산
    static void calculateCityDistance() {
        int totalDistance = 0;

        for (Point1 h : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point1 c = chickens.get(i);
                    int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
                    minDistance = Math.min(minDistance, dist);
                }
            }
            totalDistance += minDistance;
        }

        minTotalDistance = Math.min(minTotalDistance, totalDistance);
    }
}