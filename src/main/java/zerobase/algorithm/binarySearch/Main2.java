package zerobase.algorithm.binarySearch;

import java.util.Arrays;

// 자바 기본 binarySearch
public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("===데이터 존재하는 경우===");
        System.out.println(Arrays.binarySearch(arr, 1)); // 0
        System.out.println(Arrays.binarySearch(arr, 10)); // 3
        System.out.println(Arrays.binarySearch(arr, 30)); // 5

        System.out.println("===데이터 존재하지 않는 경우===");
        System.out.println(Arrays.binarySearch(arr, 3)); // -3
        System.out.println(Arrays.binarySearch(arr, 11)); // -5
        System.out.println(Arrays.binarySearch(arr, 35)); // -7
    }
}
