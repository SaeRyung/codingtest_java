package zerobase.algorithm.sort.advanced_sorting;

import java.util.Arrays;

/* # 퀵 정렬
 * - 임의의 기준 값을 정하고 그 값을 기준으로 좌우로 분할하며 정렬하는 방식
 * - 알고리즘 복잡도 : O(n²)
 * 장점
 * - 추가 적인 공간이 필요하지 않다.
 * - 배열 내 자리 바꿈만으로 가능 하기 때문에 속도가 빠르다.
 * - 양쪽 끝에 포인터를 둔 후 2개를 적절한 swap를 통해 자리를 바꿔주는 방법 */
public class Main3 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬 " + Arrays.toString(arr));
//        퀵 정렬 [2, 4, 5, 6, 7, 8, 9]
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1); // 좌측
        quickSort(arr, pivot + 1, right); // 우측
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
