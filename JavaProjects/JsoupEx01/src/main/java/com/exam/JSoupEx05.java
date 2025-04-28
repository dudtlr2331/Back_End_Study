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

public class JSoupEx05 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            URLConnection conn = new URL( "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=166c66a6369cc109ac12ca20495c5218&targetDt=20250405" ).openConnection();
            br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );

            String strHtml = br.readLine();

            Document doc = Jsoup.parse( strHtml.trim() );

            Elements codes = doc.getElementsByTag("movieCd");
            Elements ranks = doc.getElementsByTag("rank");
            Elements names = doc.getElementsByTag("movieNm");

            for ( int i = 0; i < codes.size(); i++ ) {
                Element code = codes.get(i);
                Element rank = ranks.get(i);
                Element name = names.get(i);

                System.out.printf( "%s\t%s\t%s\n", code.text(), rank.text(), name.text() );
            }

            System.out.println();

            Scanner sc = new Scanner( System.in );

            while(true){
                System.out.print( "상세 정보를 위한 코드 입력 : " );
                String code = sc.nextLine();
                if(code.equals("exit")) break;


                conn = new URL( "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?key=166c66a6369cc109ac12ca20495c5218&movieCd=" + code ).openConnection();
                br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );

                strHtml = br.readLine();

                doc = Jsoup.parse( strHtml.trim() );

                System.out.println();

                String movieNm = doc.getElementsByTag("movieNm").text();
                String movieNmEn = doc.getElementsByTag("movieNmEn").text();
                String genreNm = doc.getElementsByTag("genreNm").text();
                String directorList = doc.select("directors > director > peoplenm").text();
                String actorList = doc.select("actors > actor > peoplenm").text();

                System.out.println("영화 제목 : " + movieNm + " / " + movieNmEn);
                System.out.println("장르 : " + genreNm);
                System.out.println("감독 : " + directorList);
                System.out.println("배우 : " + actorList);
            }
            sc.close();

        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( br != null ) try { br.close(); } catch (IOException e) { }
        }
    }
}
