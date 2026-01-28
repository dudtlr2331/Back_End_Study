package algorithm.src.main.java.Backjoon;

import java.util.Scanner;

public class Backjoon11655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 대문자 처리
            if (c >= 'A' && c <= 'Z') {
                char shift = (char) (c + 13);
                if (shift > 'Z') {
                    shift = (char) (shift - 26);
                }
                sb.append(shift);
            }
            // 소문자 처리
            else if (c >= 'a' && c <= 'z') {
                char shift = (char) (c + 13);

                if (shift > 'z') {
                    shift = (char) (shift - 26);
                }
                sb.append(shift);
            }
            else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
        sc.close();
    }
}