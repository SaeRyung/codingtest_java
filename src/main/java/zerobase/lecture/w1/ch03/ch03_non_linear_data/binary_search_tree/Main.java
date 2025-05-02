package zerobase.lecture.w1.ch03.ch03_non_linear_data.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

// 비선형 자료 구조 - 이진 탐색 트리
class Node {
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right){
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree{
    Node head;

    BinarySearchTree(int key){
        this.head = new Node(key, null, null);
    }

    public void addNode(int key){
//        head 쪽이 null 인지 체크를 해보고 아무것도 없으면 노드를 하나 추가한다.
        if(this.head == null){
            this.head = new Node(key, null, null);
        } else{
//            노드가 있다면, 좌측으로 갈지 우측으로 갈 지 비교하기 위해 cur 을 잡아준다.
            Node cur = this.head;
// cur을 쫒아갈 pre 도 하나 잡아준다.
            while (true){
                Node pre = cur;
// 키의 값을 비교한다. 작다면 좌측으로 이동하기
                if(key < cur.key){
                    cur = cur.left;
// cur 이 null 이면, pre 앞 left에 현재 node를 할당하고 탈출한다.
                    if(cur == null){
                        pre.left = new Node(key, null, null);
                        break;
                    }
//                    반대로 크다면 오른쪽에 연결한다
                } else {
                    cur = cur.right;
// cur 이 null 이면, pre 앞 right에 현재 node를 할당하고 탈출한다.
                    if(cur == null){
                        pre.right = new Node(key, null, null);
                        break;
                    }
                }
            }
        }
    }

    public void removeNode(int key){
        Node parent = null; // 부모 노드
        Node successor = null; // 지우려는 대상 노드에, 후계자 찾을 변수
        Node predecessor = null; // successor 의 부모
        Node child = null; // 자식 있는지 확인하는 변수

        Node cur = this.head;
//        어떤 노드를 지울껀지 찾기
        while (cur != null){
//           지울 해당 key 값 찾기
            if(key == cur.key){
                break;
            }
//            parent 가 current 를 쫗아다니면서
            parent = cur;
//            현재 key 가 해당 key보다 크다면 왼쪽, 아니면 오른쪽 이동
            if(key < cur.key){
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
// 해당하는 노드가 없으면 return
        if(cur == null){
            System.out.println("key 에 해당하는 노드가 없습니다.");
            return;
        }

//       1. Left 노드인 경우
        if(cur.left == null && cur.right == null){
            if(parent == null){ // 트리에 노드 한개인 경우, 해당 노드를 삭제하므로  null로 바꿔준다.
                this.head = null;
            } else{
//                left 가 삭제하려는 노드이면
                if(parent.left == cur){
                    parent.left = null;
                } else {
//                    right 가 삭제하려는 노드이면
                    parent.right = null;
                }
            }
//           2. 자식 노드가 하나인 경우
//            left 또는 right 이 null인 경우
        } else if (cur.left != null && cur.right == null || cur.left == null && cur.right != null) {
            if(cur.left != null){ // 왼쪽이 null 이 아닌 경우
                child = cur.left; // 왼쪽을 child로 지정
            } else { // 오른쪽이 null 이 아닌 경우
                child = cur.right; // 오른쪽을 child 로 지정
            }

            if(parent == null){
                this.head = child;
            } else {
//                부모의 왼쪽이 삭제 노드인 경우, 자식으로 변경
                if(parent.left == cur){
                    parent.left = child;
                } else {
//                    반대인 경우, 오른쪽 자식으로 변경
                    parent.right = child;
                }
            }
        } else{ // 자식 노드가 둘인 경우
//            좌측에서 가장 큰 노드 찾기
            predecessor = cur;
            successor = cur.left;
// null 이 아닐때까지 이동
            while (successor.right != null){
                predecessor = successor;
                successor = successor.right;
            }

            predecessor.right = successor.left;
            successor.left = cur.left;
            successor.right = cur.right;

            if(parent == null){
                this.head = successor;
            } else{
                if(parent.left == cur){
                    parent.left = successor;
                } else{
                    parent.right = successor;
                }
            }

        }
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
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

public class Main {
    public static void main(String[] args) {
//        Test code
//        노드 삽입
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

//        노드 삭제
        bst.removeNode(40); // Left 노드인 경우
        bst.levelOrder(bst.head);
        bst.removeNode(25); // 자식 노드가 하나인 경우
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);
    }


}
