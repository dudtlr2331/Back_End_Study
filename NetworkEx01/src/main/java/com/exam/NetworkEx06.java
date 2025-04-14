package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx06 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            URL url = new URL("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=166c66a6369cc109ac12ca20495c5218&targetDt=20120101");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = br.readLine();
            line = line.replaceAll("><", ">\n<");
//            System.out.println(line);

            String[] lines = line.split("\n");

            for (String data : lines) {

                if(data.trim().startsWith("<rank>")){
                    System.out.println(data);
                }
                if(data.trim().startsWith("<movieNm>")){
                    System.out.println(data);
                }
            }


        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try{br.close();} catch(IOException e){}
        }

    }
}
