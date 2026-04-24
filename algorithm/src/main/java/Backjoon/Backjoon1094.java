package Backjoon;

import java.util.Scanner;

public class Backjoon1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        // 이진수에서 1의 개수를 세어주는 내장 함수
        System.out.println(Integer.bitCount(X));
    }
}