package com.exam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JSoupEx03 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            URLConnection conn = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=166c66a6369cc109ac12ca20495c5218&targetDt=20120101").openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String strHtml = br.readLine();

//            System.out.println(strHtml);

            Document doc = Jsoup.parse(strHtml.trim());
//            System.out.println(doc);

            Elements ranks = doc.getElementsByTag("rank");
            Elements names = doc.getElementsByTag("movieNm");

            System.out.println(ranks.size());

            for (int i = 0; i < ranks.size(); i++) {
                Element rank = ranks.get(i);
                Element name = names.get(i);

                System.out.printf("%s\t%s\n", rank.text(), name.text());
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try {br.close();} catch (IOException e) {}
        }
    }
}
