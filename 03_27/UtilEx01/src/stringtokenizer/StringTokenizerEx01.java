package stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {
    public static void main(String[] args) {
        String strData1 = "사과 참외 수박 딸기";

        StringTokenizer st1 = new StringTokenizer(strData1);

//        System.out.println(st1.countTokens());
        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
        }

        String strData2 = "사과&참외&수박&딸기";
        StringTokenizer st2 = new StringTokenizer(strData2, "&");

        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }

    }
}
