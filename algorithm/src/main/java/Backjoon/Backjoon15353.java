package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Backjoon15353 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // String 형태로 숫자를 읽어와 BigInteger 객체 생성
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        // A + B 연산 후 결과 출력
        // BigInteger는 불변 객체이므로 add 메서드가 결과를 담은 새 객체를 반환합니다.
        System.out.println(A.add(B));
    }
}