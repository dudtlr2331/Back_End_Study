package scanner1;

import java.util.Scanner;

public class GugudanEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력 : ");

       String strDan = sc.nextLine();
       int intDan = Integer.parseInt(strDan.replace("단",""));

//        int dan = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d\n" , intDan, i, i * intDan);
        }

        sc.close();
        System.out.println("끝");
    }
}
