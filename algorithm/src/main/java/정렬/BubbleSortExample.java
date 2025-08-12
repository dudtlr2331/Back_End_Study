package 정렬;

public class BubbleSortExample {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        bubbleSort(arr);

        System.out.println("정렬 결과:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped; // 교환 여부 체크

        // 바깥 루프: 배열 전체를 반복
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // 안쪽 루프: 앞에서부터 비교하며 큰 값 뒤로 이동
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 두 원소 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // 교환이 한 번도 없으면 정렬 완료
            if (!swapped) {
                break;
            }
        }
    }
}
