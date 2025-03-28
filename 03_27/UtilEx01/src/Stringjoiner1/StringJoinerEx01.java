package Stringjoiner1;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

public class StringJoinerEx01 {
    public static void main(String[] args) {
        StringJoiner sj1 = new StringJoiner(",");
        sj1.add("수박");
        sj1.add("사과");
        sj1.add("딸기");
        sj1.add("참외");

//        System.out.println(sj1.toString());
        String data = sj1.toString();
        System.out.println(data);

        int[] selectNumber = new int[6];
        Random random = new Random(3);
        System.out.println("선택번호 : ");
        for (int i = 0; i < 6; i++) {
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.println(selectNumber[i] + " ");
        }
        System.out.println();

        //당첨번호
        int[] winningNumber = new int[6];
        random = new Random(5);
        System.out.println("당첨번호 : ");
        for (int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.println(winningNumber[i] + " ");
        }
        System.out.println();

        //당첨여부
        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);
        boolean result = Arrays.equals(selectNumber, winningNumber);
        System.out.println("당첨여부 : ");
        if(result){
            System.out.println("당첨되지 않았습니다.");
        }
    }
}
