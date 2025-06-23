package zerobase.lecture.ch01.ch01_04permutation;

// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법(순서o, 중복x)의 각 결과를 출력하시오
// 방법1
public class Practice2 {
    void permutation(int[] arr, int depth, int n, int r){

//        depth > 세 자리 수가 만들어졌을때 출력
        if(depth == r){
            for(int i=0; i<r; i++){
                System.out.println(arr[i] + " ");
            }
            System.out.println();
            return;
        }

//        재귀함수 구조 - 탈출조건 반드시 있어야 한다.
        for(int i=depth; i<n; i++){
            permutation(arr, depth+1, n, r);
        }

    }

    public static void main(String[] args) {
//        Test code
        int[] arr = {1, 2, 3, 4};

        Practice2 p = new Practice2();
        p.permutation(arr, 0, 4, 3);
    }
}
