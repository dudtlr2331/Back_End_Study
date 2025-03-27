package data1;

import java.util.Date;

public class DateEx01 {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        Date date2 = new Date();

        //toString overriding
        System.out.println(date2);
        System.out.println(date2.toString());
        System.out.println(date2.toLocaleString());

        //년월일만 출력
        String strDate = date2.toLocaleString();
        System.out.println(strDate);

        System.out.println(strDate.substring(0,4));
        System.out.println(strDate.substring(6,8));
        System.out.println(strDate.substring(10,12));

        //Date
        System.out.println("년 : " + ( date2.getYear() + 1900));
        System.out.println("월 : " + (date2.getMonth() + 1));
        System.out.println("일 : " + (date2.getDate()));
        System.out.println("시 : " + (date2.getHours()));
        System.out.println("분 : " + (date2.getMinutes()));
        System.out.println("초 : " + (date2.getSeconds()));

        //일요일 : 0
        System.out.println("요일 : " + date2.getDay());

        // Timestamp : 0 / 1970 : 1 : 1 : 0.0.0(unix date)

        //Timestamp
        //날씨, 시간을 1/1000초 단위로 기록
        System.out.println("timestamp : " + date2.getTime());
        System.out.println("timestamp : " + System.currentTimeMillis());

    }
}
