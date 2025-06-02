package zerobase.lecture.w1.ch03.non_linear_data.tree;
// 배열을 이용한 이진 트리 구성, 순회
/*  트리의 특징
1. 하나의 노드에서 다른 노드로 이동하는 경로는 유일
2. 노드가 N개인 트리의 Edge의 수는 N-1개
3. Acyclic(Cycle이 존재하지 않음)
4. 모든 노드는 서로 연결되어 있음
5. 하나의 Edge를 끊으면 2개의 Sub-Tree로 분리됨

// 이진트리
포화 이진 트리 높이가 h 일 때, 노드의 수는 2^h+1 - 1개
포화(or 완전)이진 트리의 노드가 N개일 때, 높이는 logN
이진 트리의 노드가 N개일 때, 최대 가능 높이는 N

- 각 노드는 최대 2개의 자식을 가질 수 있음
- 자식 노드는 좌우를 구분함 => 왼쪽 자식: 부모 노드의 왼쪽 아래, 오른쪽 자식: 부모 노드의 오른쪽 아래
1. 포화 이진 트리
모든 레벨에서 노드들이 꽉 채워져 있는 트리
2. 완전 이진 트리
마지막 레벨을 제외하고 노드들이 모두 채워져있는 트리
3. 정 이진 트리
모든 노드가 0개 또는 2개의 자식 노드를 갖는 트리
4. 편향 트리
한쪽으로 기울어진 트리
5. 균형 이진 트리
모든 노드의 좌우 서브 트리 높이가 1 이상 차이 나지 않는 트리

// 이진트리의 순회
- 모든 노드를 빠뜨리거나 중복하지 않고 방문하는 연산
- 순회 종류는 4가지
ㄴ 전위 순회(현-왼-오), 중위 순회(왼-현-오), 후위 순회(왼-오-현)(DFS)
ㄴ 레벨 순회(위쪽 레벨부터 왼-오)(BFS)

// 이진 트리의 구현
- 배열: 레벨 순회 순으로 배열에 구성
부모 노드: / 2
왼쪽 노드: x 2 + 0 => 1로
오른쪽 노드: x 2 + 1 => 2로
* */
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
//        데이터가 left 배열 범위 안에 들어 있다면, 재귀함수 형태로 출력
        if(left < this.arr.length){
            this.preOrder(left);
        }
//        데이터가 right 배열 범위 안에 들어 있다면, 재귀함수 형태로 출력
        if(right<this.arr.length){
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
        bt.preOrder(0); // A B D H I E J C F G
        System.out.println();

        System.out.println("===Inorder===");
        bt.inOrder(0); // H D I B J E A F C G
        System.out.println();

        System.out.println("===Postorder===");
        bt.postOrder(0); // H I D J E B F G C A
        System.out.println();

        System.out.println("===Levelorder===");
        bt.levelOrder(0); // A B C D E F G H I J
        System.out.println();

    }
}
