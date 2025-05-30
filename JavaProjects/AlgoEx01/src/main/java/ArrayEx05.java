import java.util.Scanner;

public class ArrayEx05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("숫자입력 : ");
            numbers[i] = sc.nextDouble();
        }

        sc.close();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 22.2) {
                System.out.println("22.2의 위치 : " + i);
            }

            if (numbers[i] == 33.3) {
                System.out.println("33.3의 위치 : " + i);
            }
        }

    }
}
