package zerobase.algorithm.sort.advanced_sorting;

import java.util.Arrays;

// 알고리즘 - 정렬_2
/* # 합병정렬
* - 배열을 계속 분할해서 길이가 1이 되도록 만들고, 인접한 부분끼리 정렬하면서 합병하는 방식
* 알고리즘 복잡도: O(nlogn) */
public class Main {
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2; // 중앙값 먼저 꺼내기
            mergeSort(arr, tmp, left, mid); // 재귀적 호출, left 는 좌측 부분
            mergeSort(arr, tmp, mid + 1, right); // 재귀적 호출, right 는 우측 부분
            merge(arr, tmp, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int L = left;
        int R = mid + 1;
        int idx = L;

        // L, R 둘중에 하나라도 유효범위 안에 있으면 merge 할 때 안에 채워넣기
        while(L <= mid || R <= right){
            if(L <= mid && R <= right){
                if(arr[L] <= arr[R]){
                    tmp[idx++] = arr[L++];
                } else {
                    tmp[idx++] = arr[R++];
                }
//                L만 유효범위, R은 없는 경우
            } else if (L <= mid && R > right) {
                tmp[idx++] = arr[L++];
            } else {
                tmp[idx++] = arr[R++];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }


    public static void main(String[] args) {
//        Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
        System.out.println("합병정렬: " + Arrays.toString(arr));
//        합병정렬: [1, 2, 3, 4, 5, 7]
    }

}
