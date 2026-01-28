package tree;

import java.util.Scanner;

class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Tree {

    static Node[] tree; // 트리를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("노드의 개수를 입력해주세요.");
        int n = sc.nextInt();
        tree = new Node[n];

        int rootIndex = -1;

        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            tree[i] = new Node(left, right);

            // 부모가 -1이면 루트 노드임
            if (parent == -1) {
                rootIndex = i;
            }
        }

        // 리프 노드 개수 계산 및 출력
        System.out.println(countLeafNodes(rootIndex));

        sc.close();
    }

    // DFS 탐색을 통해 리프 노드 개수를 세는 재귀 함수
    static int countLeafNodes(int index) {
        // 유효하지 않은 노드라면 0 반환
        if (index == -1) {
            return 0;
        }

        // 현재 노드 가져오기
        Node currentNode = tree[index];

        // 왼쪽 자식과 오른쪽 자식이 모두 없다면 리프 노드임
        if (currentNode.left == -1 && currentNode.right == -1) {
            return 1;
        }

        // 자식이 있다면 리프 노드 합을 반환
        return countLeafNodes(currentNode.left) + countLeafNodes(currentNode.right);
    }
}

