package lectures.chap02.section01.tree;

/* 이진 트리 예제 */
public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root; // 트리의 루트 노드

    // 노드 클래스
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 요소 추가 (이진 탐색 트리 규칙에 따라 추가)
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) { // 데이터가 현재 노드의 데이터보다 작으면 왼쪽 서브트리로 이동
            root.left = insertRec(root.left, data);
        } else { // 데이터가 현재 노드의 데이터보다 크면 오른쪽 서브트리로 이동
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // 요소 탐색 (이진 탐색 트리 규칙에 따라 탐색)
    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node<T> root, T data) {
        if (root == null) return false;
        if (root.data.equals(data)) return true;
        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

}
