package string1;

public class StringEx02 {
    public static void main(String[] args) {
        // 문자열 = 문자배열
        // String 메서드의 사용법
        String str1 = "Hello String Hello String";

        // 문자열의 길이
        System.out.println("문자열의 길이 : " + str1.length());
        System.out.println("문자열의 길이 : " + "Hello".length());

        // 문자열 -> 문자(char)
        char ch1 = str1.charAt(0);
        System.out.println(ch1);

        char ch2 = str1.charAt(1);
        System.out.println(ch2);

        //문자열의 마지막 문자
        char ch3 = str1.charAt(str1.length()-1);
        System.out.println(ch3);

        //문자열 -> 부분 문자열
        String pstr1 = str1.substring(2);
        System.out.println(pstr1);

        // 시작 : 2, 끝 : 4
        String pstr2 = str1.substring(2,4);
        System.out.println(pstr2);

        //두번째 Hello만 출력
        String pstr3 = str1.substring(13, 18);
        System.out.println(pstr3);

        // 문자열의 위치
        int pos1 = str1.indexOf("l");
        System.out.println(pos1);

        // 문자열의 위치 - 시작 위치값 5부터 찾기 시작
        int pos2 = str1.indexOf("o", 5);
        System.out.println(pos2);

        int pos3 = str1.indexOf("z");
        System.out.println(pos3);

        //문자의 시작점
        int pos4 = str1.lastIndexOf("String");
        System.out.println(pos4);

    }
}
