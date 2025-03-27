package stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEx02 {
    public static void main(String[] args) {
        String strData = "사과&참외&&수박&&&딸기";

        StringTokenizer st = new StringTokenizer(strData, "&");
        System.out.println(st.countTokens());

        //공백데이터를 자동제거
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        String[] datas = strData.split("&");
        System.out.println(datas.length);
        for (String data : datas) {
            System.out.println(data);
        }
    }
}
