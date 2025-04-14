package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx05 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            URL url = new URL("https://news.daum.net/serieslist?id=2165");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.contains("class=\"tit_txt\"")){
                    System.out.println(
                            line.trim()
                            .replaceAll("<strong class=\"tit_txt\">", "")
                            .replaceAll("</strong>", "")
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try{br.close();} catch(IOException e){}
        }

    }
}
