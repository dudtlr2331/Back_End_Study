import java.util.Scanner;

public class Backjoon10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 26개 알파벳 개수를 담을 배열
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // 문자의 인덱스 계산 및 카운트 증가
            counts[s.charAt(i) - 'a']++;
        }

        // 결과 출력
        for (int i = 0; i < 26; i++) {
            System.out.print(counts[i] + " ");
        }
    }
}
