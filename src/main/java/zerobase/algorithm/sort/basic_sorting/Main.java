package zerobase.algorithm.sort.basic_sorting;

import java.util.Arrays;

// 알고리즘 - 정렬_1
public class Main {
//    버블 정렬
    private static void bubbleSort(int[] arr) {
//        앞에서 시작
//        for (int i=1; i<arr.length-1; i++) {
//            for (int j=0; j < arr.length-i; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }

//        뒤에서 시작
        for(int i=arr.length-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

//    삽입 정렬
    private static void insertionSort(int[] arr) {

    }

//    선택 정렬
    private static void selectionSort(int[] arr) {
    }

    public static void main(String[] args) {
//        Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));
        
        arr= new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));
        
        
        arr= new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));
    }
}
