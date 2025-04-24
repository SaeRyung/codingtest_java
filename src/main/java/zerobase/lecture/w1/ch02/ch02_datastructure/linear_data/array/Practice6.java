package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.array;

// arr 에서 중복값 제거한 새 배열
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5
// 결과: 1, 5, 3, 2, 4

import java.util.ArrayList;

public class Practice6 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] arrResult = new int[arr.length]; // 중복 제거 후 넣을 데이터

        int cnt = 0;

        for(int i=0; i<arr.length; i++){
            boolean dupFlag = false; // 중복체크 변수
            for(int j=0; j<cnt; j++){
                if(arr[i] == arrResult[j]){
                    dupFlag = true;
                }
            }
            if(dupFlag == false){
                arrResult[cnt++] = arr[i];
            }
        }

        for(int i=0; i<cnt; i++){
            System.out.print(arrResult[i] + " ");
        }
        System.out.println();
    }
}
