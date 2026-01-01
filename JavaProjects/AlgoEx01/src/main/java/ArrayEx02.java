import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayEx02 {
    public static void main(String[] args) {
        // 배열 내용 확인
        int[] ages = {60, 50, 30, 20, 10};
        // 전통
        for(int i=0; i < ages.length; i++){
            System.out.println(ages[i]);
        }

        System.out.println();

        for(int age: ages){
            System.out.println(age);
        }

        System.out.println();

        // 현대
        Arrays.toString(ages);

        Integer[] ages2 = {60, 50, 30, 20, 10};
        Stream<Integer> steam = Arrays.stream(ages2);
        steam.forEach(age -> System.out.print(age + ", "));
        System.out.println();

        Arrays.asList(ages2).forEach(age -> System.out.print(age + ": "));
    }
}
