package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx04 {
    public static void main(String[] args) {
        //InputStream is = null;
//        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            URL url = new URL("https://www.daum.net");
//            isr = new InputStreamReader(url.openStream());
            br = new BufferedReader(new InputStreamReader(url.openStream()));

//            int data = 0;
//            while((data = isr.read()) !=  -1){
//                System.out.print((char)data);
//            }

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
//            if(isr != null) try{isr.close();} catch(IOException e){}
            if (br != null) try{br.close();} catch(IOException e){}
        }

    }
}
