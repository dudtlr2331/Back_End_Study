package io1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
//                for (String column : columns) {
//                    if (column.trim().equals("논현1동")) {
//                        System.out.println(line);
//                        break;
//                    }
//                }

                if(columns[3].equals("논현1동")){
                    System.out.println(line);
                }
            }

            System.out.println("출력 완료");

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException e) {}
        }
    }
}
