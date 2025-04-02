package io1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx06 {
    public static void main(String[] args) {
//        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
//            fos = new FileOutputStream("./data2.txt");
            bos = new BufferedOutputStream(new FileOutputStream("./data2.txt"));

            bos.write('a');
            bos.write('b');
            bos.write('c');

            System.out.println("출력 성공");
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (bos != null) try { bos.close(); } catch (IOException e) {}
        }
    }
}
