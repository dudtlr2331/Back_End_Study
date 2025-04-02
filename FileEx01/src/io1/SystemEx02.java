package io1;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemEx02 {
    public static void main(String[] args) {
        //InputStream is = null;
        InputStreamReader isr = null;

        try {
            //is = System.in;
            //isr = new InputStreamReader( is );
            isr = new InputStreamReader( System.in );

            System.out.print( "입력 : ");

            //System.out.println( "입력값 : " + is.read() );
            System.out.println( "입력값 : " + (char)isr.read() );
            System.out.println( "입력값 : " + (char)isr.read() );
            System.out.println( "입력값 : " + (char)isr.read() );

        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( isr != null ) try { isr.close(); } catch (IOException e) { }
        }
    }
}
