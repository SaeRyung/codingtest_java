package zerobase.lecture.ch03.non_linear_data.avl_tree;
// AVL트리 - 삭제
class AVLTree2 extends AVLTree{
    public void delete(int key){
        this.head = delete(this.head, key);
    }
    public Node delete(Node node, int key){
        if(node == null){
            return null;
        }
        if(key < node.key){
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
//            삭제 부분
            if(node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node predecessor = node;
                Node successor = node.left;

                while (successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                }
                predecessor.right = successor.left;
                node.key = successor.key;
            }
        }
//        높이에 대한 갱신
        node.height = Math.max(height(node.left), height(node.right)) + 1;
//        갱신 후 밸런스 체크
        int balance = getBalance(node);

        //        LL 체크
        if(balance > 1 && getBalance(node.left) > 0){
            return rightRotate(node);
        }
//        RR 체크
        if(balance < -1 && getBalance(node.right) < 0){
            return leftRotate(node);
        }
//        LR 체크
        if(balance > 1 && getBalance(node.left) < 0){
            return lrRotate(node);
        }
//        RL 체크
        if(balance < -1 && getBalance(node.right) > 0){
            return rlRotate(node);
        }
        return node;
    }
}

public class Practice2 {
    public static void main(String[] args) {
//        Test code
        AVLTree2 avl = new AVLTree2();

        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(10);
        avl.levelOrder(avl.head); // 30 20 40 10
        avl.delete(40); // LL
        avl.levelOrder(avl.head); // 20 10 30

        avl.insert(40);
        avl.delete(10); // RR
        avl.levelOrder(avl.head); // 30 20 40

        avl.insert(25);
        avl.delete(40); // LR
        avl.levelOrder(avl.head); // 25 20 30

        avl.insert(27);
        avl.delete(20); // RL
        avl.levelOrder(avl.head); // 27 25 30
    }
}
