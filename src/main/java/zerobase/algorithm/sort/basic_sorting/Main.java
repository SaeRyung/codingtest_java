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
//        앞에서 비교
        for(int i=1; i<arr.length; i++) {
            for(int j=i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else { // 앞의 데이터는 이미 정렬이 되어 있으므로 break 추가
                    break;
                }
            }
        }

    }

//    선택 정렬
    private static void selectionSort(int[] arr) {
        // 최소
        // 최소값을 찾아 가장 앞쪽으로 교환하는 방식
        for(int i=0; i<arr.length-1; i++) {
            int min = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
        }

        // 최대
//        최대값을 찾아 가장 뒤쪽으로 교환하는 방식
        for(int i=arr.length-1; i>0; i--) {
            int max = i;
            for (int j=i-1; j>=0; j--) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }

    public static void main(String[] args) {
//        Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7]
        
        arr= new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7]
        
        
        arr= new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7]
    }
}
