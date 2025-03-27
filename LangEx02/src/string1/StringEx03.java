package string1;

public class StringEx03 {
    public static void main(String[] args) {
        String str1 = "Hello World";
        String rstr = str1.replaceAll("Hello", "안녕");
        System.out.println(rstr);


        String jstr = str1.concat("안녕");
        System.out.println(jstr);

        //대소문자 변환
        System.out.println("hello".toUpperCase());
        System.out.println("HELLO".toLowerCase());

        //공백제거 (문자열 앞뒤)
        String ostr1 = " Hello String ";
        System.out.println(ostr1.length());
        String ostr2 = ostr1.trim();
        System.out.println(ostr2);
        System.out.println(ostr2.length());

        //구분자 중심의 문자열 분리
        String sstr1 = "apple,banana,pineapple,kiwi";
        String[] strArr1 = sstr1.split(",");
        for (String str : strArr1) {
            System.out.println(str);
        }

        //구분자 중심 문자열 결합
        // 배열 -> 문자열
        String jstr1 = String.join(",", strArr1);
        System.out.println(jstr1);

        //구분자 중심 문자열 결합(+)
        //배열 -> 문자열
//        String jstr2 =
    }
}
