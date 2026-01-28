package algorithm.src.main.java.Backjoon;

import java.util.Scanner;

public class Backjoon10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 단어 입력 받기
        String original = sc.next();

        // StringBuilder를 이용해 문자열을 뒤집음
        String reversed = new StringBuilder(original).reverse().toString();

        // 원본과 뒤집은 문자열이 같은지 비교
        if (original.equals(reversed)) {
            System.out.println(1); // 팰린드롬이면 1
        } else {
            System.out.println(0); // 아니면 0
        }

        sc.close();
    }
}