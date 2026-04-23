package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1062 {
    static int N, K;
    static int[] wordBits;
    static int maxCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1. 필수 글자 5개보다 적게 가르치면 아무것도 못 읽음
        if (K < 5) {
            System.out.println(0);
            return;
        }
        // 2. 모든 글자를 가르칠 수 있으면 다 읽음
        if (K == 26) {
            System.out.println(N);
            return;
        }

        wordBits = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int bit = 0;
            for (int j = 0; j < s.length(); j++) {
                bit |= (1 << (s.charAt(j) - 'a'));
            }
            wordBits[i] = bit;
        }

        // 'a', 'n', 't', 'i', 'c'는 미리 배운 상태로 시작
        int initialBit = 0;
        initialBit |= (1 << ('a' - 'a'));
        initialBit |= (1 << ('n' - 'a'));
        initialBit |= (1 << ('t' - 'a'));
        initialBit |= (1 << ('i' - 'a'));
        initialBit |= (1 << ('c' - 'a'));

        // 3. 백트래킹으로 추가 글자 선택 시작 (K-5개)
        dfs(0, 0, initialBit);

        System.out.println(maxCount);
    }

    static void dfs(int alphaIdx, int count, int learnedBit) {
        // K-5개의 추가 글자를 다 골랐을 때
        if (count == K - 5) {
            int readableCount = 0;
            for (int wordBit : wordBits) {
                // 단어의 비트가 배운 글자 비트의 부분집합인지 확인
                if ((wordBit & learnedBit) == wordBit) {
                    readableCount++;
                }
            }
            maxCount = Math.max(maxCount, readableCount);
            return;
        }

        // 알파벳 'a'부터 'z'까지 순회
        for (int i = alphaIdx; i < 26; i++) {
            // 이미 필수 글자로 배운 글자는 건너뜀
            if ((learnedBit & (1 << i)) == 0) {
                dfs(i + 1, count + 1, learnedBit | (1 << i));
            }
        }
    }
}