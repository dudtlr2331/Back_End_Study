public class backjoon11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 1. 오름차순 정렬
        Arrays.sort(arr);
        
        int sum = 0;      # 이전 사람까지의 누적 시간
        int total = 0;    # 전체 사람들의 대기 시간 합
        
        // 2. 누적 시간 계산
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            total += sum;
        }
        
        System.out.println(total);
        sc.close();
    }
}
