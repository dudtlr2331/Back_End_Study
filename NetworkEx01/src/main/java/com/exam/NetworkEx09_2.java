package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx09_2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        //attributes
        try {
            URLConnection conn = new URL("https://news.daum.net/").openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            String[] lines = null;

            while ((line = br.readLine()) != null) {
                if (line.contains("componentTitle=이 시각 주요뉴스")) {
                    line = line.replaceAll("><", ">\n<");
                    lines = line.split("\n");
//                    System.out.println(line);
                }
            }

            for (String data : lines) {
//                System.out.println(data);
                if(data.trim().startsWith("<strong class=\"tit_txt\">")){
                    System.out.println(data);
                }
            }


        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try{ br.close(); } catch(IOException e){}
        }

    }
}
