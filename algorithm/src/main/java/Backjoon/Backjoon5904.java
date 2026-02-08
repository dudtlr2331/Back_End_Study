package Backjoon;
import java.util.Scanner;

public class Backjoon5904 {
    static char answer; // 정답을 저장할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1. N을 포함할 수 있는 최초의 수열 길이(length)와 단계(k)를 구함
        long length = 3; // S(0)의 길이
        int k = 0;

        while (length < N) {
            k++;
            // S(k)의 길이 = S(k-1) * 2 + (k+3)
            length = 2 * length + (k + 3);
        }

        // 2. 분할 정복 시작
        solve(N, k, length);

        System.out.println(answer);
        sc.close();
    }

    /**
     * @param n   찾으려는 인덱스
     * @param k   현재 단계
     * @param len 현재 단계 수열의 전체 길이 S(k)
     */
    public static void solve(long n, int k, long len) {
        // 가운데 영역("m o ... o")의 길이
        long midLen = k + 3;
        // 왼쪽 영역(S(k-1))의 길이
        long prevLen = (len - midLen) / 2;

        // Case 1: N이 왼쪽 영역에 있는 경우
        if (n <= prevLen) {
            solve(n, k - 1, prevLen);
        }
        // Case 2: N이 오른쪽 영역에 있는 경우
        else if (n > prevLen + midLen) {
            // 오른쪽 영역은 S(k-1)이므로, 인덱스를 조정하여 재귀 호출
            // 앞부분(왼쪽 + 가운데) 길이를 뺌
            solve(n - (prevLen + midLen), k - 1, prevLen);
        }
        // Case 3: N이 가운데 영역에 있는 경우
        else {
            // 가운데 영역은 "m" + (k+2개의 "o")로 구성됨
            // 가운데 영역의 첫 번째 글자일 때만 'm'
            if (n - prevLen == 1) {
                answer = 'm';
            } else {
                answer = 'o';
            }
        }
    }
}