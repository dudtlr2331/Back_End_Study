package day2;

import java.util.Arrays;
import java.util.Scanner;

public class St5 {
    public String solution(String my_string, int n) {
        String answer = "";

        for (int i = 0; i < my_string.length(); i++) {
            answer += my_string;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
