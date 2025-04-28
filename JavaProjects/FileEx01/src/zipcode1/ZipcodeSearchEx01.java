package zipcode1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ZipcodeSearchEx01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("동 이름 입력 > ");
        String strDong = sc.nextLine();
        sc.close();

        BufferedReader br = null;

        if(strDong.length() < 2){
            System.out.println("동이름을 2자 이상 입력해주세요.");
            System.exit(0);
        }

        //처리



        //출력
    }
}
