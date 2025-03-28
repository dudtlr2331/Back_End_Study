package arrays1;

import java.util.Arrays;

public class ArrayEx01 {
    public static void main(String[] args) {
        //Arrays
        String[] strArray = {"aaa", "bbb", "ccc", "ddd", "eee"};

        //배열의 내용 값
        System.out.println(strArray);
        for (String str : strArray) {
            System.out.println(str);
        }

        System.out.println(Arrays.toString(strArray));

        //초기화
        Arrays.fill(strArray, "xxx"); //모두 변경
        System.out.println(Arrays.toString(strArray));
        Arrays.fill(strArray, 0, 2, "yyy"); // 부분적으로 변경
        System.out.println(Arrays.toString(strArray));

        //내용값 비교
        String[] strArray1 = {"aaa", "bbb", "ccc"};
        String[ ] strArray2 = {"aaa", "bbb", "ccc"};

        System.out.println(strArray1 == strArray2); //주소값에 대한 비교
        System.out.println(Arrays.equals(strArray1, strArray2)); // 내용값에 대한 비교

        if(Arrays.equals(strArray1, strArray2)){
            System.out.println("내용값 같음");
        }else {
            System.out.println("내용값 다름");
        }

        // 정렬(sort)
        int[] intArray = {5, 2, 3, 1, 4};

        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        String[] nameArray = {"xMan", "Alex", "Xman", "Bob", "Curl", "flex", "alex"};

        Arrays.sort(nameArray); //아스키코드 값으로 정렬
        System.out.println(Arrays.toString(nameArray));

        // 내용 검색 (위치)
        int pos = Arrays.binarySearch(nameArray, "Curl");
        System.out.println(pos);
    }
}
