package day3;

public class St1 {
    public String solution(String my_string, String letter) {
        String answer = "";

        for (int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) != letter.charAt(0)) {
                answer += my_string.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        St1 st1 = new St1();
        String answer = st1.solution("Hello", "l");
        System.out.println(answer);
    }
}
