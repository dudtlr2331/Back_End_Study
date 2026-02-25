package Backjoon;

import java.util.*;
import java.io.*;

public class Backjoon2910 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 전체 숫자 개수
        int C = sc.nextInt(); // 숫자의 최대값

        HashMap<Integer, Integer> countMap = new HashMap<>(); // 빈도 저장
        HashMap<Integer, Integer> orderMap = new HashMap<>(); // 등장 순서 저장
        ArrayList<Integer> list = new ArrayList<>();         // 중복 제거된 숫자 리스트

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
                orderMap.put(num, i);
                list.add(num);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }

        Collections.sort(list, (a, b) -> {
            // 빈도가 다르면 -> 빈도 높은 순(내림차순)
            if (countMap.get(a) != countMap.get(b)) {
                return countMap.get(b) - countMap.get(a);
            }
            // 빈도가 같으면 -> 먼저 나온 순(오름차순)
            return orderMap.get(a) - orderMap.get(b);
        });

        for (int num : list) {
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                System.out.print(num + " ");
            }
        }
    }
}