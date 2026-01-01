import java.util.Scanner;

public class ExamEx02 {
    public static int med3(int a, int b, int c) {
        if(a >= b){
            if(b >= c){
                return b;
            }else if(a >= c){
                return a;
            } else {
                return c;
            }
        }else if( a > b){
            return a;
        }else if(b > c){
            return c;
        }else {
            return b;
        }
    }

    public static void main(String[] args) {
        int a, b, c;

        Scanner sc = new Scanner(System.in);
        System.out.println("세 정수의 중간값을 구합니다.");
        System.out.print("a의 값");
        a = sc.nextInt();
        System.out.print("b의 값");
        b = sc.nextInt();
        System.out.print("c의 값");
        c = sc.nextInt();

        System.out.println("세 정수의 중간값은? " + med3(a, b, c));
    }
}
