package io1;

import java.io.FileInputStream;
import java.io.IOException;

public class IOEx02 {
    public static void main(String[] args) {
        //상대경로를 통해서 data.txt 파일 읽기
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("./data.txt");

            int data = 0;
            while ((data = fis.read()) != -1){
                if (data == '\r'){
                    System.out.println("(r)");
                }else if (data == '\n'){
                    System.out.println("(n)");
                }else {
                    System.out.println((char) data);
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            try{ fis.close(); } catch(IOException e){}
        }
    }
}
