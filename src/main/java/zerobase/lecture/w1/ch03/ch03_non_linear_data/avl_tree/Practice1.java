package zerobase.lecture.w1.ch03.ch03_non_linear_data.avl_tree;
// 비선형 자료구조 - 이진탐색트리 2
// AVL 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int key;
    int height; // 현재 노드 높이
    Node left;
    Node right;

    public Node(int key, Node left, Node right){
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree{
    Node head;

//    노드 높이 정보 반환
    public int height(Node node){
//        들어온 정보가 null 이라면 return -1
        if(node == null){
            return -1;
        }
//        아니라면 height 정보 리턴
        return node.height;
    }

//    LL - 오른쪽 방향으로 1회전
    public Node rightRotate(Node node){
//        우선 노드의 l-node를 찍어준다.
        Node lNode = node.left;
// node의 left에 lNode를 삽입
        node.left = lNode.right;
        lNode.right = node;
// 높이값 정보 변경된다. left와 right 중 더 큰 경우를 선택하고 + 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        // 높이값 정보 변경된다. lNode의 left와 right 중 더 큰 경우를 선택하고 + 1
        node.height = Math.max(height(lNode.left), height(lNode.right)) + 1;

        return lNode;
    }
//    RR - 왼쪽 방향으로 1회전
    public Node leftRotate(Node node){
//        오른쪽 노드를 rNode로 잡아준다.
        Node rNode = node.right;
// rNode 의 left가 있다면 연결
        node.right = rNode.left;
//        들어온 노드를 rNode 의 left로 연결
        rNode.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        node.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }
//    LR - RR 회전 후 LL 회전 / 2회전
    public Node lrRotate(Node node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
//   RL - LL 회전 후 RR 회전 / 2회전
    public Node rlRotate(Node node){
       node.right = rightRotate(node.right);
       return leftRotate(node);
    }
//    트리에서 현재 노드 기점으로 균형 정보 계산 메서드, 왼쪽-오른쪽 노드 값 리턴해서 균형 체크(-1, 0, 1)
//    완성도 높이기 위한 예외처리
    public int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }
//    노드 삽입
    public void insert(int key){
        this.head = insert(this.head, key);
    }
//    노드 삽입 시 재귀형태로 들어오도록 구현
    public Node insert(Node node, int key){
        if(node == null){
            return new Node(key, null, null);
        }
        if(key < node.key){
            node.left = insert(node.left, key);
        } else{
            node.right = insert(node.right, key);
        }
//        새로 추가한 노드에 대한 높이 정보 업데이트
        node.height = Math.max(height(node.left), height(node.right)) + 1;
//        삽입 직후 높이 차이 계산
        int balance = getBalance(node);

//        LL 체크
        if(balance > 1 && key < node.left.key){
            return rightRotate(node);
        }
//        RR 체크
        if(balance < -1 && key > node.right.key){
            return leftRotate(node);
        }
//        LR 체크
        if(balance > 1 && key > node.left.key){
            return lrRotate(node);
        }
//        RL 체크
        if(balance < -1 && key < node.right.key){
            return rlRotate(node);
        }
        return node;
    }
    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
//        Test code
        AVLTree avl = new AVLTree();

//        Insert
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);     // LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.insert(50);     // RR
        avl.levelOrder(avl.head);

        avl.insert(5);
        avl.insert(7);     // LR
        avl.levelOrder(avl.head);

        avl.insert(60);
        avl.insert(55);     // RL
        avl.levelOrder(avl.head);
    }
}
