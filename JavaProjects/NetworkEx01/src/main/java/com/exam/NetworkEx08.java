package com.exam;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx08 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            URLConnection conn = new URL("https://t1.daumcdn.net/news/202504/10/sportalkr/20250410113010719nttn.jpg").openConnection();

            bis = new BufferedInputStream(conn.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream("./download.jpg"));

            int data = 0;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            System.out.println("전송 완료");

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (bis != null) try{ bis.close(); } catch(IOException e){}
            if (bos != null) try{ bos.close(); } catch(IOException e){}
        }

    }
}
