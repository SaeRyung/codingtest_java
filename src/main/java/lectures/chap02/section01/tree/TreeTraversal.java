package lectures.chap02.section01.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal<T> {

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /* 전위 순회 메소드 (루트 -> 왼쪽 -> 오른쪽) */
    public List<T> preOrder(Node<T> root) {
        List<T> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    // 출력문이 아닌 반환값 메소드 관리 위해 작성, 결과 list에 담음
    private void preOrderRec(Node<T> root, List<T> result) {
        if(root != null){
            result.add(root.data);
            preOrderRec(root.left, result);
            preOrderRec(root.right, result);
        }
    }

    /* 중위 순회 (왼쪽 -> 루트 -> 오른쪽) */
    public List<T> inOrder(Node<T> root) {
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node<T> root, List<T> result) {
        if(root != null){
            inOrderRec(root.left, result);
            result.add(root.data);
            inOrderRec(root.right, result);
        }
    }

    /* 후위 순회 (왼쪽 -> 오른쪽 -> 루트) */
    public List<T> postOrder(Node<T> root) {
        List<T> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private void postOrderRec(Node<T> root, List<T> result) {
        if(root != null){
            postOrderRec(root.left, result);
            postOrderRec(root.right, result);
            result.add(root.data);
        }
    }
}
