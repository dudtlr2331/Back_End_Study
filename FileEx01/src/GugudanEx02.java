import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GugudanEx02 {
    public static void main(String[] args) {
        // try-with-resources 사용
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("단수 > ");
                String dan = br.readLine();

                if (dan.equals("0")) {
                    System.out.println("프로그램 종료");
                    break;
                }

                try {
                    int intToDan = Integer.parseInt(dan);
                    
                    // 입력값 검증
                    if (intToDan < 1 || intToDan > 9) {
                        System.out.println("1부터 9까지의 숫자만 입력해주세요.");
                        continue;
                    }

                    // 구구단 출력 (보기 좋게 정렬)
                    System.out.printf("=== %d단 ===\n", intToDan);
                    for (int i = 1; i <= 9; i++) {
                        System.out.printf("%d X %d = %2d\n", intToDan, i, (intToDan * i));
                    }
                    System.out.println();
                    
                } catch (NumberFormatException e) {
                    System.out.println("올바른 숫자를 입력해주세요.");
                }
            }
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }
}