package hashAlgorithm;

import java.util.*;

public class HashLv12 {
    public int solution(int[] nums) {
        // 폰켓몬 종류를 저장할 Set
        Set<Integer> uniquePokemon = new HashSet<>();

        // 폰켓몬 종류를 Set에 추가하여 중복 제거
        for (int num : nums) {
            uniquePokemon.add(num);
        }

        // N/2 마리만 선택할 수 있음
        int maxSelectable = nums.length / 2;

        // 선택할 수 있는 폰켓몬 종류의 최대값은
        // 전체 종류 수와 N/2 중 작은 값
        return Math.min(uniquePokemon.size(), maxSelectable);
    }
}
