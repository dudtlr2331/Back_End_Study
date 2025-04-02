package io1;

import java.io.FileReader;
import java.io.IOException;

public class IOEx07 {
    public static void main(String[] args) {
        FileReader fr = null;

        try {
            fr = new FileReader("./data.txt");

            int data = 0;

            while ((data = fr.read()) != -1){
                System.out.print((char)data);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (fr != null) try { fr.close(); } catch (IOException e) {}
        }
    }
}
