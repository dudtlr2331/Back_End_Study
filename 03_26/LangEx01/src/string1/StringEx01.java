package string1;

public class StringEx01 {
    public static void main(String[] args) {
        String str1 = new String();
        String str2 = new String("Hello String");
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);

        System.out.println(str3);
        System.out.println(str3.toString());

        //
        String str21 = "Hello String";
        String str22 = "Hello String";
        System.out.println(str21 == str22);
        System.out.println(str21.equals(str22));

        String str11 = new String("Hello String");
        String str12 = new String("Hello String");
        System.out.println(str11 == str12);
        System.out.println(str11.equals(str12));
    }
}
