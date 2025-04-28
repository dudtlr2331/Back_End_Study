package exam;

public class JuminCheck {
    public static void main(String[] args) {
//        java JuminCheck xxxxxx-xxxxxxx
//  2	3	4	5	6	7	8	9	2	3	4	5
        if (args[2].length() == 14) {
            String jumin = args[2];
            jumin = jumin.replace("-", "");

            int sum = 0;
            int[] weights = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};

            for (int i = 0; i < 12; i++) {
                sum += (jumin.charAt(i) - '0') * weights[i];
            }

            sum = (11 - (sum % 11)) % 10;


            if (sum == (jumin.charAt(12) - '0')){
                System.out.println("주민등록번호 형식이 맞음");
            }else {
                System.out.println("주민등록번호 형식이 아닙니다.");
            }
        }else {
            System.out.println("틀림");
        }
    }
}
