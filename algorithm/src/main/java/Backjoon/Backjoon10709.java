package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon10709 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 행
        int W = Integer.parseInt(st.nextToken()); // 열

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            int cloudDist = -1; // 현재 행에서 가장 마지막에 본 구름과의 거리

            for (int j = 0; j < W; j++) {
                char current = line.charAt(j);

                if (current == 'c') {
                    // 구름을 발견하면 거리를 0으로 초기화
                    cloudDist = 0;
                } else if (cloudDist != -1) {
                    // 이전에 구름을 본 적이 있다면 거리를 1씩 증가
                    cloudDist++;
                }

                sb.append(cloudDist).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}