package zerobase.lecture.w1.ch03.non_linear_data_test.tree;
/*
전위 순회 : 현재 -> 왼쪽 -> 오른쪽
중위 순회 : 왼쪽 -> 현재 -> 오른쪽
후위 순회 : 왼쪽 -> 오른쪽 -> 현재
레벨 순회 : 왼->오 BFS
* */

class BinaryTree{
    char[] arr;

    BinaryTree(char[] data){
        this.arr = data.clone();
    }

    //    전위 순회 : 현재노드 -> 왼쪽노드 -> 오른쪽노드
//    재귀함수 특징으로 구현
    public void preOrder(int idx) {
         // 들어온 데이터 인덱스 먼저 출력
        System.out.print(this.arr[idx] + " ");

//        들어온 데이터의 left, right 구하기
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

//        데이터가 left 배열 범위 안에 들어 있다면, 재귀함수 형태로 출력
        if(left < this.arr.length) {
            this.preOrder(left);
        }

//        데이터가 right 배열 범위 안에 들어 있다면, 재귀함수 형태로 출력
        if(right < this.arr.length){
            this.preOrder(right);
        }

    }

    //    중위 순회
    public void inOrder(int idx) {
//        인덱스 먼저 구해준다.
       int left = 2 * idx + 1;
       int right = 2 * idx + 2;
//        왼쪽 출력
        if(left < this.arr.length){
            this.inOrder(left);
        }
//        현재 출력- 왼쪽으로 내려간 다음 출력
        System.out.print(this.arr[idx] + " ");

//        오른쪽 출력
        if(right < this.arr.length){
            this.inOrder(right);
        }
    }

    //    후위 순회
    public void postOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        //        왼쪽 출력
        if(left < this.arr.length){
            this.postOrder(left);
        }
        //        오른쪽 출력
        if(right < this.arr.length){
            this.postOrder(right);
        }
        //        현재 출력 - 뒤에서 출력
        System.out.print(this.arr[idx] + " ");

    }

    //    레벨 순회
    public void levelOrder(int idx) {
        for(int i=0; i<arr.length; i++) {
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
        bt.preOrder(0); // A B D H I E J C F G
        System.out.println();

        System.out.println("===Inorder===");
        bt.inOrder(0); // H D I B J E A F C G
        System.out.println();

        System.out.println("===Postorder===");
        bt.postOrder(0); // H D I B J E F C G A
        System.out.println();

        System.out.println("===Levelorder===");
        bt.levelOrder(0); // A B C D E F G H I J
        System.out.println();

    }
}
