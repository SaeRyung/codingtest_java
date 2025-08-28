package zerobase.algorithm.twoPointers;

import java.util.Arrays;

// 알고리즘 - 투 포인터
public class Main {
    public static int[] forLoop(int[] arr, int target) {
        int[] result = {-1, 1};

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(sum == target) {
                    result[0] = i;
                    result[1] = j-1; // 해당 구간
                    break;
                }
                sum += arr[j];
            }
//            한번 더 체크, 찾은 타겟
            if(sum == target) {
                break;
            }
        }
        return result;
    }

    public static int[] twoPointers(int[] arr, int target) {
        int p1 = 0, p2 = 0, sum = 0;
        int[] result = {-1, -1};

        while (true) {
            if(sum > target) {
                sum -= arr[p1++];
            } else if (p2 == arr.length) {
                break;
            } else {
                sum += arr[p2++];
            }
            if(sum == target) {
                result[0] = p1;
                result[1] = p2 - 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(forLoop(arr, 9))); //[4, 5]
        System.out.println(Arrays.toString(forLoop(arr, 14))); //[-1, -1] 없어서 -1 리턴
        System.out.println();
        System.out.println(Arrays.toString(twoPointers(arr, 9))); //[4, 5]
        System.out.println(Arrays.toString(twoPointers(arr, 14))); //[-1, -1] 없어서 -1 리턴
    }
}
