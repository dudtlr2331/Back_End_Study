package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 1. 학생 정보를 담는 클래스 정의
class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 2. 정렬 기준 재정의 (Comparable 인터페이스의 compareTo)
    @Override
    public int compareTo(Student o) {
        // 국어 점수가 다르면 내림차순
        if (this.kor != o.kor) {
            return o.kor - this.kor;
        }
        // 영어 점수가 다르면 오름차순
        if (this.eng != o.eng) {
            return this.eng - o.eng;
        }
        // 수학 점수가 다르면 내림차순
        if (this.math != o.math) {
            return o.math - this.math;
        }
        // 모든 점수가 같으면 이름 사전 순 오름차순
        return this.name.compareTo(o.name);
    }
}

public class Backjoon10825 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, kor, eng, math));
        }

        // 3. 정렬 수행 (Student 클래스에 정의된 compareTo 기준)
        Collections.sort(list);

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.name).append("\n");
        }
        System.out.print(sb);
    }
}