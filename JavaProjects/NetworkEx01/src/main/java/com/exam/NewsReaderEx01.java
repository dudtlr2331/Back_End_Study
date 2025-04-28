package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NewsReaderEx01 {
    public static void main(String[] args) {

        BufferedReader br = null;

        try {
            URL url = new URL( "https://news.daum.net/" );
            br = new BufferedReader( new InputStreamReader( url.openStream() ) );

            String data = null;

            while( ( data = br.readLine() ) != null ) {
                if( data.contains( "<ul class=\"list_newsheadline2\">" ) ) break;
            }

            data = data.replaceAll( ">\\s+<", "><" );
            data = data.replaceAll( "><", ">\n<" );

            String[] lines = data.split("\n" );

            boolean flag = false;
            for ( String line : lines ) {
                if( line.contains( "<strong class=\"tit_txt\">" ) ) {
                    System.out.println( line );
                }
            }
        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( br != null ) try { br.close(); } catch ( IOException e ) {}
        }
    }
}