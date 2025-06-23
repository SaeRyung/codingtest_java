package zerobase.lecture.ch03.non_linear_data.tree;
// 연결리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node{
    char data;
    Node left, right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2 {
    Node head;

    BinaryTree2(){}
    BinaryTree2(char[] arr){
        Node[] nodes = new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            nodes[i] = new Node(arr[i], null, null);
        }

//        현재 노드들을 자식노드에 연결
        for(int i=0;i<arr.length;i++){
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < arr.length){
                nodes[i].left = nodes[left];
            }

            if(right < arr.length){
                nodes[i].right = nodes[right];
            }
        }
        this.head = nodes[0];
    }
//    전위 순회
    public void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }
//    중위 순회
    public void inOrder(Node node){
        if (node == null) {
            return;
        }
        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }
//    후위 순회
    public void postOrder(Node node){
        if (node == null) {
            return;
        }
        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

//    레벨 순회
    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.data + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

}

public class Practice2 {
    public static void main(String[] args) {
//        Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("===Preorder===");
        bt.preOrder(bt.head); // A B D H I E J C F G
        System.out.println();

        System.out.println("===Inorder===");
        bt.inOrder(bt.head); // H D I B J E A F C G
        System.out.println();

        System.out.println("===Postorder===");
        bt.postOrder(bt.head); // H D I B J E F C G A
        System.out.println();

        System.out.println("===Levelorder===");
        bt.levelOrder(bt.head); // A B C D E F G H I J
        System.out.println();
    }
}
