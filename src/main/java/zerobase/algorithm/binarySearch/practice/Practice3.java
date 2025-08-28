package zerobase.algorithm.binarySearch.practice;

import java.util.Arrays;

/* 2차원 행렬에서 이진 탐색으로 데이터 찾기
* row x col 행렬 데이터가 주어졌을 때, target을 이진 탐색으로 찾는 프로그램을 작성하세요.
* 각 행의 데이터는 오름차순으로 정렬 상태
*
* 입출력 예시
* 행렬 : {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}}
*
* target: 3
* 출력: true
*
* target: 13
* 출력: false */
public class Practice3 {
    public static boolean solution(int[][] arr, int target) {
        if(arr == null || arr.length == 0) {
            return false;
        }

        int left = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        int right = rows * cols - 1; // 행렬의 끝 인덱스

        while(left <= right) {
//            int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;

            if(arr[mid/cols][mid%cols]==target) {
//                중간값이 타겟과 일치하는 경우
                return true;
            } else if(arr[mid/cols][mid%cols]<target) {
//                중간값이 찾는 값보다 작은 경우, 오름차순 정렬된 배열에서 target 이 중간값의 오른쪽에 위치 동작 - 탐색 범위를 오른쪽 절반으로 축소
                left = mid + 1;
            } else {
//                중간값이 찾는 값보다 큰 경우, 오름차순 정렬된 배열에서 target 이 중간값 왼쪽에 위치 동작 - 탐색 범위를 왼쪽 절반으로 축소
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        Test code
        int[][] matrix = {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}};
        System.out.println(solution(matrix, 3)); //true
        System.out.println(solution(matrix, 13)); // false
        System.out.println(solution(matrix, 35)); // true
    }
}
