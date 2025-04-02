package io1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IOEx09 {
    public static void main(String[] args) {
//        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
//            fw = new FileWriter("./data2.txt");
            bw = new BufferedWriter(new FileWriter("./data2.txt", true)); //append를 쓰면 추가모드가 된다.

            bw.write("Hello");
            bw.write("Hello");
//            fw.write("\r\n");
            bw.write(System.lineSeparator());
            bw.write("Hello");

            System.out.println("출력완료");
        } catch (IOException e) {
            System.out.println("출력완료");
        } finally {
            if (bw != null) try { bw.close(); } catch (IOException e) {  }
        }
    }
}
