package zerobase.lecture.w1.ch03.ch03_non_linear_data.tree;
// 배열을 이용한 이진 트리 구성, 순회
class BinaryTree{
    char[] arr;

    BinaryTree(char[] data){
        this.arr = data.clone();
    }

//    전위 순회 : 현재노드 -> 왼쪽노드 -> 오른쪽노드
//    재귀함수 특징으로 구현
    public void preOrder(int idx) {
        System.out.print(this.arr[idx] + " "); // 들어온 데이터 인덱스 먼저 출력

//        들어온 데이터의 left, right 구하기
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
//        데이터가 left 배열 범위 안에 들어 있다면
        if(left < this.arr.length){
            this.preOrder(left);
        }
//        데이터가 right 배열 범위 안에 들어 있다면
        if(right<this.arr.length){
            this.preOrder(right);
        }
    }

    public void inOrder(int idx) {
//        인덱스 먼저 구해준다.
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

//        왼쪽 출력
        if(left < this.arr.length){
            this.inOrder(left);
        }
//        현재 출력
        System.out.print(this.arr[idx] + " ");

//        오른쪽 출력
        if(right < this.arr.length){
            this.inOrder(right);
        }
    }

    public void postOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        //        왼쪽 출력
        if(left < this.arr.length){
            this.inOrder(left);
        }

        //        오른쪽 출력
        if(right < this.arr.length){
            this.inOrder(right);
        }

        //        현재 출력
        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(int idx) {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
//        Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("===Preorder===");
        bt.preOrder(0);
        System.out.println();

        System.out.println("===Inorder===");
        bt.inOrder(0);
        System.out.println();

        System.out.println("===Postorder===");
        bt.postOrder(0);
        System.out.println();

        System.out.println("===Levelorder===");
        bt.levelOrder(0);
        System.out.println();

    }
}
