package io1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOEx08 {
    public static void main(String[] args) {
//        FileReader fr = null;
        BufferedReader br = null;

        try {
//            fr = new FileReader("./data.txt");
//            br = new BufferedReader(fr);

            br = new BufferedReader(new FileReader("./data2.txt"));


            //한 자씩 읽어 들이는 구문
            /*int data = 0;

            while ((data = br.read()) != -1){
                System.out.print((char)data);
            }
            System.out.println();*/

            //한 줄 (엔터키)씩 읽기
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
        }
    }
}
