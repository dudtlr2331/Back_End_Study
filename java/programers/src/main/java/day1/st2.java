package day1;

public class st2 {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 두 분수의 공통 분모 구하기 (통분)
        int commonDenom = denom1 * denom2;
        int newNumer = numer1 * denom2 + numer2 * denom1;

        // 최대공약수로 기약분수 만들기
        int gcd = getGCD(newNumer, commonDenom);

        // 기약 분수로 반환
        int[] answer = { newNumer / gcd, commonDenom / gcd };
        return answer;
    }

    // 최대공약수 구하기 (유클리드 호제법)
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        //10	[1, 3, 5, 7, 9]
        //15	[1, 3, 5, 7, 9, 11, 13, 15]
        st2 st = new st2();
//        ArrayList<Integer> answer = st.solution(10);

//        for (int num : answer) {
//            System.out.print(num + " ");
//        }
    }
}
