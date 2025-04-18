package zerobase.lecture.w1.wednesday.ch02_datastructure.linear_data.array;

// 배열 arr의 데이터 순서를 거꾸로 변경하세요
// 추가 배열을 사용하지 않고 구현

// arr: 1, 3, 5, 7, 9
// 결과: 9, 7, 5, 3, 1

import java.util.Arrays;

public class Practice3 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int len = arr.length;
        int[] reverseArr = new int[len];

        for(int i=0; i<len; i++){
            reverseArr[i] = arr[len-(i+1)];
        }
        System.out.println("결과: " + Arrays.toString(reverseArr));
    }
}
