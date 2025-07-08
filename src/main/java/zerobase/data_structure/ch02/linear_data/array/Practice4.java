package zerobase.data_structure.ch02.linear_data.array;

// 배열 arr에서 peek 값 모두 출력
// arr : 3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11
// 결과: 3, 6, 5, 10, 11

import java.util.ArrayList;

public class Practice4 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};
        ArrayList<Integer> result = new ArrayList<Integer>();

//        처음 값 비교해서 큰 수 대입
        if(arr[0] > arr[1]){
            result.add(arr[0]);
        }
        for(int i=1; i<arr.length-1; i++){

            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                result.add(arr[i]);
            }
        }

        if(arr[arr.length-1] > arr[arr.length-2]){
            result.add(arr[arr.length-1]);
        }
        System.out.println(result);
    }
}
