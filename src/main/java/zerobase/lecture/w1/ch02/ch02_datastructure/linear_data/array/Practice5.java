package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.array;

// 배열 arr 의 값을 오름차순으로 출력
// arr : 5, 3, 1, 4, 6, 1
// 결과: 1, 1, 3, 4, 5, 6

import java.util.Arrays;

public class Practice5 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 1};

        for(int i=0; i<arr.length; i++){
            int tmp;
            for(int j=0; j<arr.length-1; j++){
                if(arr[i] < arr[j]){
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
