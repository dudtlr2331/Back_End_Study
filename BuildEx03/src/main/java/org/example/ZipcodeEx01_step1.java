package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ZipcodeEx01_step1 {
    public static void main(String[] args) {
        //파일 읽어오기
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));

            String line = "";
            while((line = br.readLine()) != null){
//                System.out.println(line);

                String [] address = line.split(",");
                String sql = String.format("insert into zipcode values ('%s','%s','%s','%s','%s','%s',%s)",
                        address[0], address[1], address[2], address[3], address[4], address[5], address[6]);

                System.out.println(sql);
            }
        } catch (IOException e) {
            System.out.println("[에러]" + e.getMessage());
        } finally {
            if(br != null) try{ br.close(); } catch(IOException e){}
        }
    }
}
