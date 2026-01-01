import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayEx01 {
    public static void main(String[] args) {
        String[] strArray = {"aaa", "bbb", "ccc"};

        System.out.println(Arrays.toString(strArray));
        System.out.println(strArray.toString());

        Arrays.fill(strArray, "ddd");
        System.out.println(Arrays.toString(strArray));

        String[] strArray1 = {"aaa", "bbb", "ccc"};
        String[] strArray2 = {"aaa", "bbb", "ccc"};

        // 참조값 비교
        System.out.println(strArray1 == strArray2);
//        System.out.println(strArray1.equals(strArray2));
        // 내용비교
        System.out.println(Arrays.equals(strArray1, strArray2));

        // 정렬
        int[] intArray = { 5, 2, 3, 1, 4};

        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        // 정렬

    }
}
