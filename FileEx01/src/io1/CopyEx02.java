package io1;

import java.io.*;

public class CopyEx02 {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("./data2.txt"));
            bw = new BufferedWriter(new FileWriter("./copy2.txt"));

            String line = null;
            while ((line = br.readLine()) != null) {
//                bw.write(line);
                bw.write(line + System.lineSeparator());
            }
            System.out.println("출력 완료");
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
            if (bw != null) try { bw.close(); } catch (IOException e) {}
        }

    }
}
