package string1;

import java.sql.SQLOutput;

public class InitCap {
    public static void main(String[] args) {
        // 입력 검사
        if ( args.length != 1 ) {
            System.out.println( "Usage: java InitCapEx01 <string>" );
        } else {
            System.out.println( "정상입력" );

            String[] names = args[0].split( " " );

            // 검사
            for ( String name : names ) {
                System.out.println( name );
            }

            System.out.println( names[0].substring( 0, 1 ) + " " + names[0].substring( 1 ) );
            System.out.println( names[1].substring( 0, 1 ) + " " + names[1].substring( 1 ) );
            System.out.println( names[2].substring( 0, 1 ) + " " + names[2].substring( 1 ) );

            //System.out.println( names[0].substring( 0, 1 ).toUpperCase() + names[0].substring( 1 ) );
            //System.out.println( names[1].substring( 0, 1 ).toUpperCase() + names[1].substring( 1 ) );
            //System.out.println( names[2].substring( 0, 1 ).toUpperCase() + names[2].substring( 1 ) );

            for ( int i = 0; i < names.length; i++ ) {
                System.out.println( names[i].substring( 0, 1 ).toUpperCase() + names[i].substring( 1 ) );

                names[i] = names[i].substring( 0, 1 ).toUpperCase() + names[i].substring( 1 );
            }

            for ( String name : names ) {
                System.out.println( name );
            }

            String returnName = String.join( " ", names );
            System.out.println( returnName );
        }
    }
}
