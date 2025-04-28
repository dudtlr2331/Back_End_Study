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

public class JSoupEx04 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            URLConnection conn = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=166c66a6369cc109ac12ca20495c5218&targetDt=20120101").openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String strHtml = br.readLine();
            Document doc = Jsoup.parse(strHtml.trim());

            Elements movieCds = doc.getElementsByTag("movieCd");
            Elements movieNms = doc.getElementsByTag("movieNm");
            Elements openDts = doc.getElementsByTag("openDt");
            Elements audiCnts = doc.getElementsByTag("audiCnt");
            Elements audiAccs = doc.getElementsByTag("audiAcc");
            Elements audiChanges = doc.getElementsByTag("audiChange");

            for (int i = 0; i < movieCds.size(); i++) {
                Element movieCd = movieCds.get(i);
                Element movieNm = movieNms.get(i);
                Element openDt = openDts.get(i);
                Element audiCnt = audiCnts.get(i);
                Element audiAcc = audiAccs.get(i);
                Element audiChange = audiChanges.get(i);

                System.out.printf("%s\t%s\t%s\t%s\t%s\n", movieCd.text(), movieNm.text(), openDt.text(), audiCnt.text(), audiAcc.text(), audiChange.text());
            }

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try {br.close();} catch (IOException e) {}
        }
    }
}
