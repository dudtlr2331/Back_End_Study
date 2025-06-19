package day2;

public class st1 {
    public int solution(int slice, int n) {
        int pizza = 0;

        for (int i = 1; i <= n; i++) {
            if(i % slice == 1) {
                pizza++;
            }
        }

        return pizza;
    }

    public static void main(String[] args) {
        st1 st1 = new st1();

//        7	10	2
//        4	12	3
        System.out.println(st1.solution(7, 10));
        System.out.println(st1.solution(4, 12));
    }
}
