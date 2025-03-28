package data1;

import java.sql.SQLOutput;
import java.util.Calendar;

public class CalenderEx01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toString());

        // get 상수값
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));

        //일요일 : 1
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        //시 분  초
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        //timestamp
        System.out.println(calendar.getTimeInMillis());

    }
}
