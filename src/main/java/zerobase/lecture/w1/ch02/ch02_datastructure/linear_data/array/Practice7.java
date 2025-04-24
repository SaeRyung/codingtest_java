package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.array;

// 2차원배열 arr을 시계방향 90도로 회전시킨 결과를 출력
/* arr:
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15

결과:
11 6 1
12 7 2
13 8 3
14 9 4
15 10 5
*/

public class Practice7 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        int rows = arr.length;
        int colums = arr[0].length;

        for(int i=0; i<colums; i++){
            for(int j=rows-1; j>=0; j--){
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}
