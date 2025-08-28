package zerobase.algorithm.binarySearch;
/* 이진 탐색 */
public class Main {
//    반복문 구조
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(target == arr[mid]) {
                // 찾았으므로 인덱스 반환
                return mid;
            } else if(target < arr[mid]) {
                // 왼쪽 절반에서 계속 탐색
                right = mid - 1;
            } else {
                // 오른쪽 절반에서 계속 탐색
                left = mid + 1;
            }
        }
        return -1;
    }
//    재귀 호출 구조
    public static int binarySearch2(int[] arr, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if(target == arr[mid]) {
            return mid;
        } else if(target < arr[mid]) {
            return binarySearch2(arr, target, left, mid - 1);
        } else {
            return binarySearch2(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("Index: " + binarySearch(arr, 30));
        System.out.println();
        System.out.println("Index: " + binarySearch2(arr, 30, 0, arr.length-1));
    }
}
