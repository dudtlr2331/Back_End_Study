package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Backjoon3474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            // 5의 배수 개수를 세어 0의 개수를 찾는 로직
            for (int i = 5; i <= n; i *= 5) {
                count += n / i;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
