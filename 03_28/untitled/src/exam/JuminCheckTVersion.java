package exam;

public class JuminCheckTVersion {
    public static void main(String[] args) {

        if ( args.length != 1 ) {
            System.out.println( "Usage: java JuminCheckEx01 <주민등록번호>" );
            System.exit(0);
        }

        if ( args[0].length() != 14 ) {
            System.out.println( "14자리를 입력하셔야 합니다." );
            System.exit(0);
        }

        String[] jumins = args[0].split( "-" );
        if ( jumins[0].length() != 6 || jumins[1].length() != 7 ) {
            System.out.println( "앞자리와 뒤자리의 길이가 틀립니다." );
            System.exit(0);
        }

        System.out.println( "정상 입력" );

        // - 제거
        String strJumin = args[0].replaceAll( "-", "" );
        System.out.println( strJumin );

        // 한 글자씩 분리
        //System.out.println( strJumin.substring( 0, 1 ) );
        //System.out.println( strJumin.substring( 1, 2 ) );
        //System.out.println( strJumin.substring( 2, 3 ) );

        int num01 = Integer.parseInt( strJumin.substring( 0, 1 ) ) * 2;
        int num02 = Integer.parseInt( strJumin.substring( 1, 2 ) ) * 3;
        int num03 = Integer.parseInt( strJumin.substring( 2, 3 ) ) * 4;
        int num04 = Integer.parseInt( strJumin.substring( 3, 4 ) ) * 5;
        int num05 = Integer.parseInt( strJumin.substring( 4, 5 ) ) * 6;
        int num06 = Integer.parseInt( strJumin.substring( 5, 6 ) ) * 7;
        int num07 = Integer.parseInt( strJumin.substring( 6, 7 ) ) * 8;
        int num08 = Integer.parseInt( strJumin.substring( 7, 8 ) ) * 9;
        int num09 = Integer.parseInt( strJumin.substring( 8, 9 ) ) * 2;
        int num10 = Integer.parseInt( strJumin.substring( 9, 10 ) ) * 3;
        int num11 = Integer.parseInt( strJumin.substring( 10, 11 ) ) * 4;
        int num12 = Integer.parseInt( strJumin.substring( 11, 12 ) ) * 5;

        int lastNum = Integer.parseInt( strJumin.substring( 12, 13 ) );

        int sum = num01 + num02 + num03 + num04 + num05 + num06 + num07 + num08 + num09 + num10 + num11 + num12;

        int resultNum = sum % 11;
        resultNum = 11 - resultNum;
        resultNum = resultNum % 10;

        //System.out.println( lastNum );
        //System.out.println( resultNum );

        if ( lastNum == resultNum ) {
            System.out.println( "주민등록번호 형식이 맞음" );
        } else {
            System.out.println( "주민등록번호 형식이 틀립" );
        }
    }
}
