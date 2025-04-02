package zipcode1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZipcodeSearchEx04 {
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
        System.out.println("정상 입력 : " + strDong);

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] address = line.split(",");
                if (address[3].startsWith(strDong)) {
                    System.out.printf("[%s] %s %s %s %s %s\n", address[0], address[1], address[2], address[3], address[4], address[5] );
                }
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if(br != null) try{ br.close(); } catch(IOException e){}
        }

        //출력
    }
}
