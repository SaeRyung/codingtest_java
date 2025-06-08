package zerobase.lecture.w1.ch03.non_linear_data_test.binary_search_tree;

class Node{
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key){
        if(this.head == null){
            this.head = new Node(key, null, null);
        }
        Node cur = this.head;
        while(true){
            Node pre = cur;
            if(key < cur.key){
                cur = cur.left;
                if(cur == null){
                    pre.left = new Node(key, null, null);
                    break;
                }
            } else {
                cur = cur.right;
                if(cur == null){
                    pre.right = new Node(key, null, null);
                    break;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.addNode(20);
    }
}
