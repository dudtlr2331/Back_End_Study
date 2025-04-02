import java.util.Scanner;

public class GugudanEx01  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("단수 > ");
            int dan = sc.nextInt();

            if (dan == 0) {
                break;
            }

            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d X %d = %d", dan, i, (dan * i ));
                System.out.println();
            }
        }
        System.out.println("프로그램 종료");
    }
}
