package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon14469 {
    // 소의 정보를 담을 클래스
    static class Cow implements Comparable<Cow> {
        int arrivalTime, checkTime;

        Cow(int arrivalTime, int checkTime) {
            this.arrivalTime = arrivalTime;
            this.checkTime = checkTime;
        }

        // 도착 시간 기준 오름차순 정렬
        @Override
        public int compareTo(Cow o) {
            if (this.arrivalTime == o.arrivalTime) {
                return this.checkTime - o.checkTime;
            }
            return this.arrivalTime - o.arrivalTime;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Cow> cows = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
            cows.add(new Cow(arrival, check));
        }

        // 1. 도착 시간 기준으로 소들을 정렬
        Collections.sort(cows);

        int currentTime = 0;

        // 2. 소들을 순차적으로 검문소에 통과시킴
        for (Cow cow : cows) {
            // 소가 도착했을 때 아직 검문소가 비어있다면 (이전 소의 검문이 끝난 후 공백이 있다면)
            if (currentTime < cow.arrivalTime) {
                currentTime = cow.arrivalTime; // 소가 도착한 시간으로 타임라인 이동
            }
            // 검문 시간만큼 타임라인이 누적됨
            currentTime += cow.checkTime;
        }

        System.out.println(currentTime);
    }
}