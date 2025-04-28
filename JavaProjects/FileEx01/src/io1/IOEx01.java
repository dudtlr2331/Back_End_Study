package io1;

import java.io.FileInputStream;
import java.io.IOException;

public class IOEx01 {
    public static void main(String[] args) {
        // FileInputStream - byte 단위 파일 내용 읽기

        FileInputStream fis = null;

        try {
            // 파일 열기
            fis = new FileInputStream( "c:/java/data.txt" );

            // 한 바이트 읽기
            //System.out.println( "문자 : " + fis.read() );

            //int data = fis.read();          // ascii
            //System.out.println( "문자 : " + (char)data );
            //data = fis.read();
            //System.out.println( "문자 : " + (char)data );
            //data = fis.read();
            //System.out.println( "문자 : " + (char)data );

            // 전체 데이터 읽기
            int data = 0;
            while ( ( data = fis.read() ) != -1 ) {
                System.out.print( (char)data );
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            try { fis.close(); } catch ( IOException e ) {}
        }
    }
}
