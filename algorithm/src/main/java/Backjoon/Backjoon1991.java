package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 노드 구조 정의
class Node {
    char value;
    Node left, right;

    Node(char value) {
        this.value = value;
    }
}

public class Backjoon1991 {
    static Node[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[26]; // A-Z까지 최대 26개

        // 1. 노드 초기화
        for (int i = 0; i < n; i++) {
            char val = (char) ('A' + i);
            tree[i] = new Node(val);
        }

        // 2. 트리 구성 (간선 연결)
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') {
                tree[parent - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        // 3. 순회 결과 출력
        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
        System.out.println();
    }

    // 전위 순회: 루트 -> 왼쪽 -> 오른쪽
    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회: 왼쪽 -> 루트 -> 오른쪽
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회: 왼쪽 -> 오른쪽 -> 루트
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
