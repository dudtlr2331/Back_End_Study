package 정렬;

public class QuickSortExample {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("퀵 정렬 결과:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);

            // pivot 왼쪽 부분 정렬
            quickSort(arr, left, pivotIndex - 1);
            // pivot 오른쪽 부분 정렬
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 마지막 요소를 pivot으로
        int i = left - 1; // pivot보다 작은 값이 위치할 인덱스

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1; // pivot의 최종 위치 반환
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
