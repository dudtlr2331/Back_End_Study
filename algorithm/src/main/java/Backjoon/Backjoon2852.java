package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int score1 = 0, score2 = 0;
        int time1 = 0, time2 = 0;
        int lastTime = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] timeStr = st.nextToken().split(":");
            int currentTime = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

            // 1. 이전 득점 시점부터 현재까지 누가 이기고 있었는지 확인하여 시간 합산
            if (score1 > score2) {
                time1 += (currentTime - lastTime);
            } else if (score2 > score1) {
                time2 += (currentTime - lastTime);
            }

            // 2. 득점 업데이트 및 마지막 득점 시간 갱신
            if (team == 1) score1++;
            else score2++;

            lastTime = currentTime;
        }

        // 3. 경기 종료(48:00 = 2880초)까지 남은 리드 시간 처리
        int endTime = 48 * 60;
        if (score1 > score2) {
            time1 += (endTime - lastTime);
        } else if (score2 > score1) {
            time2 += (endTime - lastTime);
        }

        // 4. 형식에 맞춰 출력 (00:00)
        System.out.printf("%02d:%02d\n", time1 / 60, time1 % 60);
        System.out.printf("%02d:%02d\n", time2 / 60, time2 % 60);

    }
}
