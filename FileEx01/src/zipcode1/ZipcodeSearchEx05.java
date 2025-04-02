package zipcode1;

import java.io.*;
import java.util.Scanner;

public class ZipcodeSearchEx05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("분류 할 지역 이름 입력 > ");
        String strArea = sc.nextLine();
        sc.close();

        BufferedReader br = null;
        BufferedWriter bw = null;

        if(strArea.length() < 2){
            System.out.println("동이름을 2자 이상 입력해주세요.");
            System.exit(0);
        }

        System.out.println("정상 입력 : " + strArea);

        //처리
        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
            bw = new BufferedWriter(new FileWriter("./" + strArea + ".txt"));
            String line = null;

            while((line = br.readLine()) != null){
                String[] arr = line.split(",");

                if(arr[1].startsWith(strArea)){
                    bw.write(line + "\r\n");
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
