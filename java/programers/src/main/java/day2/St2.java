package day2;

public class St2 {
    public int solution(int n) {
        int pizza = 0;

        for (int i = 1; i <= n; i++) {
            if(i * 6 % n == 0) {
                pizza = i;
                break;
            }
        }

        return pizza;
    }

    public static void main(String[] args) {
        St2 st1 = new St2();

//        6	1
//        10 5
//        4	2
        System.out.println(st1.solution(6));
        System.out.println(st1.solution(10));
        System.out.println(st1.solution(4));
    }
}
