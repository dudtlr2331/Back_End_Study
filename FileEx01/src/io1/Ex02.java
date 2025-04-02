package io1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("동 이름 입력 > ");
        String data = sc.nextLine();
        sc.close();

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
            String line = null;

            if (data.length() >= 2) {
                System.out.println("정상 입력입니다.");

                String[] columns = line.split(",");
                if(columns[3].contains(data)){
                    System.out.printf("[%s] %s%s%s%s", columns[0], columns[1], columns[2], columns[3], columns[4]);
                }

            } else {
                System.out.println("동 이름을 2글자 이상 입력해주세요.");
                System.exit(0);
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
        }
    }
}
