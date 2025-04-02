package io1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemEx03 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
//            isr = new InputStreamReader(System.in);
//            br = new BufferedReader(isr);
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("입력 : ");

            //한 자씩 읽기
//            System.out.println("입력 값 : " + (char)br.read());
//            System.out.println("입력 값 : " + (char)br.read());
//            System.out.println("입력 값 : " + (char)br.read());
            // 한 줄씩 읽기
            System.out.println("입력 값 : " + br.readLine());

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
        }
    }
}
