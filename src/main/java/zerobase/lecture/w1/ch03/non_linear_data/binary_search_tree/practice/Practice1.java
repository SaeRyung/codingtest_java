package zerobase.lecture.w1.ch03.non_linear_data.binary_search_tree.practice;

import java.util.ArrayList;

/* 주어진 이진 탐색 트리에서 N번째로 작은 수 구하기
입력 트리: 3, 1, 4, null, 2
N: 1
결과: 1

// 입력트리: 5, 3, 6, 2, 4, null, null, 1
// N: 3
// 결과: 3

오름차순으로 정렬하기 때문에 inOrder
* */
class Node{
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right){
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree() {}
    BinarySearchTree(int key){
        this.head = new Node(key, null, null);
    }

    public void addNode(int key){
        this.head = this.addNode(this.head, key);
    }

    public Node addNode(Node cur, int key){
        if(cur == null){
            return new Node(key, null, null);
        }
        if(key < cur.key){
            cur.left = addNode(cur.left, key);
        } else {
            cur.right = addNode(cur.right, key);
        }
        return cur;
    }
}


public class Practice1 {
    public static void solution(Integer[] data, int n) {
        BinarySearchTree bst = new BinarySearchTree(data[0]); //root 족에 데이터 잡힐 수 있도록 0 넣기

        for (int i = 0; i < data.length; i++) {
            if(data[i] == null){
                continue;
            }

            bst.addNode(data[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        inOrder(bst.head, list);
        System.out.println(list.get(n-1));
    }

    public static void inOrder(Node node, ArrayList list) {
        if(node == null){
            return;
        }
        inOrder(node.left, list); // 좌측 먼저 순회할 수 있도록 left로 들어가기
        list.add(node.key);
        inOrder(node.right, list);
    }

    public static void main(String[] args) {
//        Test code
        Integer[] data = {3, 1, 4, null, 2};
        int n = 1;
        solution(data, n);

        data = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        n = 3;
        solution(data, n);
    }
}
