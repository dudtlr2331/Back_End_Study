package hashAlgorithm;

import java.util.Arrays;

public class HashLv13 {
    public boolean solution(String[] phone_book) {
        // 전화번호를 정렬합니다.
        Arrays.sort(phone_book);

        // 인접한 전화번호끼리 접두어 관계를 확인합니다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 현재 전화번호와 다음 전화번호를 비교합니다.
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false; // 접두어가 발견되면 false 반환
            }
        }

        return true; // 접두어가 없으면 true 반환
    }
}
