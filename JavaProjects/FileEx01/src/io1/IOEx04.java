package io1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx04 {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("./data2.txt");

            //ascii
//            fos.write(65);
//            fos.write('a');
            fos.write('a');
            fos.write('b');
            fos.write('c');
            fos.write('\t');
            fos.write('d');
            fos.write('e');
            fos.write('f');
            fos.write('\r');
            fos.write('\n');
            fos.write('g');
            fos.write('h');
            fos.write('i');

            System.out.println("출력 완료");

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }
}
