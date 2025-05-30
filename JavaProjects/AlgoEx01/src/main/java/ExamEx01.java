import java.util.Scanner;

public class ExamEx01 {
    public static int min3(int a, int b, int c) {
        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;

        return min;
    }

    public static void main(String[] args) {
        int a, b, c;

        Scanner sc = new Scanner(System.in);
        System.out.println("세 정수의 최소값을 구합니다.");
        System.out.print("a의 값");
        a = sc.nextInt();
        System.out.print("b의 값");
        b = sc.nextInt();
        System.out.print("c의 값");
        c = sc.nextInt();

        System.out.println("세 정수의 최소값은? " + min3(a, b, c));
    }
}
