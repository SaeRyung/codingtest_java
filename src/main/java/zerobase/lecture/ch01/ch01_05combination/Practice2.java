package zerobase.lecture.ch01.ch01_05combination;
// Practice
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서X, 중복X)의 각 결과를 출력하시오
public class Practice2 {
    void combination(int[] arr, boolean[] visited, int depth, int n, int r){

        // 재귀형태이므로 리턴조건
        if (r == 0){
            for(int i=0; i<n; i++){
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // 끝까지 도달한 경우
        if(depth == n){
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth+1, n, r-1);

        visited[depth] = false;
        combination(arr, visited, depth+1, n, r);

    }

    public static void main(String[] args) {
//        Test code
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = {false, false, false, false};

        Practice2 p = new Practice2();
        p.combination(arr, visited, 0, 4, 3);
    }

}
