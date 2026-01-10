import java.util.*;
import java.io.*;

public class Backjoon1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 포켓몬 수
        int m = Integer.parseInt(st.nextToken()); // 문제 수

        HashMap<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName[i] = name;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String query = br.readLine();

            if (isNumeric(query)) {
                int index = Integer.parseInt(query);
                sb.append(numToName[index]).append("\n");
            } else {
                sb.append(nameToNum.get(query)).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) return false;
        char firstChar = str.charAt(0);
        return firstChar >= '0' && firstChar <= '9';
    }
}