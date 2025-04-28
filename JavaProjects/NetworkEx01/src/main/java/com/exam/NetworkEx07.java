package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx07 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            URLConnection conn = new URL("https://www.daum.net").openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;

            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try{ br.close(); } catch(IOException e){}
        }

    }
}
