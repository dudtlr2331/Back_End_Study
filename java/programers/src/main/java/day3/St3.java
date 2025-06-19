package day3;

public class St3 {
    public int solution(int n, int k) {
        int answer = 0;
        //12000, 2000
        int 양꼬치 = n * 12000;
        int 음료수 = (k * 2000) - (n / 10) * 2000;

        answer = 양꼬치 + 음료수;

        return answer;
    }

    public static void main(String[] args) {
        St3 st1 = new St3();
        int answer = st1.solution(10, 3);
        System.out.println(answer);
    }
}
