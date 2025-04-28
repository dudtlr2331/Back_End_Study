package data1;

import java.util.Calendar;

public class CalenderEx04 {
    public static void main(String[] args) {
        int year = 2025;
        int month = 3;

        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();

        startCalendar.set( year, month-1, 1 );
        endCalendar.set( year, month, 1 - 1 );

        // 1일의 요일
        int startDayOfWeek = startCalendar.get( Calendar.DAY_OF_WEEK );
        // 마지막 날짜
        int endDate = endCalendar.get( Calendar.DATE );

        System.out.println( " SU MO TU WE TH FR SA" );

        for ( int i=1 ; i<startDayOfWeek ; i++ ) {
            // 3
            System.out.print( "   " );
        }

        // i - 달력 요일
        // n - 위치 / n = 7 : 토요일
        for ( int i=1, n=startDayOfWeek ; i<=endDate ; i++, n++ ) {
            // 2 : 1
            System.out.print( ( i < 10 ) ? "  " + i : " " + i );
            if( n % 7 == 0 ) {
                System.out.println();
            }
        }

    }
}
