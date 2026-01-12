public class Backjoon9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수 T 입력
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 의상 수 n 입력
            int n = Integer.parseInt(br.readLine());

            // 종류(Category)별 개수를 저장할 Map
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷 이름은 계산에 필요 없으므로 버림
                String category = st.nextToken(); // 옷 종류

                // 해당 종류의 개수를 +1 증가 (없으면 기본값 0에서 시작)
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int result = 1;

            // 각 종류별 개수(val)에 +1(안 입는 경우)을 하여 곱함
            for (int val : map.values()) {
                result *= (val + 1);
            }

            // 알몸인 상태(아무것도 안 입은 1가지 경우)를 뺌
            sb.append(result - 1).append('\n');
        }

        System.out.println(sb);
    }
}