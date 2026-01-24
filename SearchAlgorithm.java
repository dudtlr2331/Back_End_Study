import java.util.ArrayList;
import java.util.Collections;

public class SearchAlgorithm {
    // 그래프를 저장할 인접 리스트
    static ArrayList<Integer>[] graph;
    // 방문 여부를 체크할 배열
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 6; // 노드의 개수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 간선 연결 (예시 데이터)
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(3, 6);

        // 번호가 작은 노드부터 방문하기 위해 정렬 (선택 사항)
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        System.out.print("DFS 탐색 순서: ");
        dfs(1); // 1번 노드부터 탐색 시작
    }

    // 간선 추가 메소드
    static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u); // 무방향 그래프인 경우 양쪽 추가
    }

    // DFS 재귀 함수
    static void dfs(int node) {
        // 1. 현재 노드 방문 처리
        visited[node] = true;
        System.out.print(node + " ");

        // 2. 인접한 노드들을 순회
        for (int next : graph[node]) {
            // 3. 방문하지 않은 노드가 있다면 재귀 호출
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
