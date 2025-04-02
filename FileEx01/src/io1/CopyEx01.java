package io1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
//            fis = new FileInputStream("./data2.txt");
//            fos = new FileOutputStream("./copy.txt");
            fis = new FileInputStream("./tree.jpg") ;
            fos = new FileOutputStream("./copyImage.jpg");

            int data = 0;

            while ((data = fis.read()) != -1) {
                //복사의 중요내용
                fos.write(data);
            }

            System.out.println("복사 완료");
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (fis != null) try { fis.close(); } catch (IOException e) {}
            if (fos != null) try { fos.close(); } catch (IOException e) {}
        }
    }
}
