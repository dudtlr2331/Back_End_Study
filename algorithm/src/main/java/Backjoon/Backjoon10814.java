package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 사용자 정보를 담을 클래스 정의
class Member {
    int age;
    String name;
    int idx; // 가입 순서 (직접 관리할 경우)

    public Member(int age, String name, int idx) {
        this.age = age;
        this.name = name;
        this.idx = idx;
    }
}

public class Backjoon10814 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            // 가입 순서 i를 함께 저장
            members[i] = new Member(age, name, i);
        }

        // 다중 조건 정렬 (나이순 -> 가입순)
        Arrays.sort(members, (m1, m2) -> {
            if (m1.age == m2.age) {
                // 나이가 같으면 가입 순서(idx) 비교
                return m1.idx - m2.idx;
            }
            // 나이가 다르면 나이순 정렬
            return m1.age - m2.age;
        });

        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
    }
}