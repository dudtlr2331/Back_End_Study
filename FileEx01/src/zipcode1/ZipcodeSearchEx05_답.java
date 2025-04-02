package zipcode1;

import java.io.*;
import java.util.Scanner;

public class ZipcodeSearchEx05_답 {
    public static void main(String[] args) {
        BufferedReader br = null;

        BufferedWriter bw1 = null;
        BufferedWriter bw2 = null;
        BufferedWriter bw3 = null;

        try {
            br = new BufferedReader( new FileReader( "./zipcode_seoul_utf8_type2.csv" ) );

            bw1 = new BufferedWriter( new FileWriter( "./서울.txt" ) );
            bw2 = new BufferedWriter( new FileWriter( "./경기.txt" ) );
            bw3 = new BufferedWriter( new FileWriter( "./인천.txt" ) );

            String data = null;
            while( ( data = br.readLine() ) != null ) {

                String[] addresses = data.split( "," );
                String address = String.format( "[%s] %s %s %s %s %s\n",
                        addresses[0], addresses[1], addresses[2],
                        addresses[3], addresses[4], addresses[5] );

                if( addresses[1].equals( "서울" ) ) {
                    bw1.write( address );
                } else if( addresses[1].equals( "경기" ) ) {
                    bw2.write( address );
                } else if( addresses[1].equals( "인천" ) ) {
                    bw3.write( address );
                }
            }

            System.out.println( "분산 저장 완료" );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( br != null ) try { br.close(); } catch(IOException e) {}

            if ( bw1 != null ) try { bw1.close(); } catch(IOException e) {}
            if ( bw2 != null ) try { bw2.close(); } catch(IOException e) {}
            if ( bw3 != null ) try { bw3.close(); } catch(IOException e) {}
        }
    }
}
