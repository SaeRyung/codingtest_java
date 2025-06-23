package zerobase.lecture.ch03.non_linear_data_test.tree.practice;
/* 종이 접기
종이를 반으로 접었을 때, 안으로 파인 부분은 0, 볼록 튀어나온 부분은 1이라고 하자
종이를 접을 때는 오른쪽에서 왼쪽으로 접는다
종이를 N번 접었을 때의 접힌 상태를 출력하는 문제를 작성하세요

입력: 1
출력: 0

입력: 2
출력: 0, 0, 1

입력: 3
출력: 0, 0, 1, 0, 0, 1, 1
* */
public class Practice1 {
    public static void solution(int n){
//    배열의 사이즈 만들어주기, 가장 끝은 사용하지 않고 배열 만들어도 괜찮음.
        int[] arr = new int[(int) Math.pow(2,n)];
       //한번 접는것은 무조건 0
        arr[0] = 0;
//            0 또는 1 에 대한 데이터 쌓일 수 있도록
        for(int i=0; i<(int)Math.pow(2, n-1)-1; i++){
//            왼쪽 -> 0
            arr[i*2+1] = 0;
//            오른쪽 -> 1
            arr[i*2+2] = 1;
        }
        inOrder(arr, 0);
        System.out.println();
    }

    //    중위순회
    public static void inOrder(int[] arr, int idx){
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

//        배열 마지막 부분을 사용하지 않아 배열길이 -1
        if(left < arr.length-1){
            inOrder(arr, left);
        }

        System.out.print(arr[idx] + " ");

        if(right < arr.length-1){
            inOrder(arr, right);
        }
    }

    public static void main(String[] args) {
//        Test code
        solution(1); // 0
        solution(2); // 0 0 1
        solution(3); // 0 0 1 0 0 1 1
    }
}
