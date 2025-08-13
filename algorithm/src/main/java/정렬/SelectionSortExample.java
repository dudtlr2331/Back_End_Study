package 정렬;

public class SelectionSortExample {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        selectionSort(arr);

        System.out.println("정렬 결과:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // 최소값 인덱스 저장

            // 최소값 위치 찾기
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 최소값과 현재 위치 교환
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
