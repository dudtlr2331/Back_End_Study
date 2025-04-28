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
import java.util.Scanner;

public class JSoupEx06 {
    public static void main(String[] args) {
        BufferedReader br = null;
        Scanner sc = new Scanner(System.in);

        try {
            while(true){
                System.out.print("상세 정보를 위한 코드 입력 : ");
                String movieCd = sc.nextLine();

                if(movieCd.equals("exit")) break;

                URLConnection conn = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?key=166c66a6369cc109ac12ca20495c5218&movieCd="+ movieCd).openConnection();
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String strHtml = br.readLine();
                Document doc = Jsoup.parse(strHtml.trim());

                Elements movieNm = doc.getElementsByTag("movieNm");
                Elements movieNmEn = doc.getElementsByTag("movieNmEn");
                Elements genreNm = doc.getElementsByTag("genreNm");
                Elements directorList = doc.select("directors > director > peoplenm");
                Elements actorList = doc.select("actors > actor > peoplenm");

                System.out.println("영화명 : " + movieNm.text());
                System.out.println("영화명 : " + movieNmEn.text());
                System.out.println("장르 : " + genreNm.text());

                for (int i = 0; i < directorList.size(); i++) {
                    if (i == 0) System.out.print("감독명 : ");
                    System.out.println(directorList.get(i).text());
                    if (i < directorList.size() - 1) System.out.print(", ");
                }

                for (int i = 0; i < actorList.size(); i++) {
                    if (i == 0) System.out.print("배우명 : ");
                    System.out.print(actorList.get(i).text());
                    if (i < actorList.size() - 1) System.out.print(", ");
                }

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) try {br.close();} catch (IOException e) {}
        }
    }
}
