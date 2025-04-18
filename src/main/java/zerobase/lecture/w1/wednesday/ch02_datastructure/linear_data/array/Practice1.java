package zerobase.lecture.w1.wednesday.ch02_datastructure.linear_data.array;

// 배열 arr 의 모든 데이터에 대해서 짝수 데이터들의 평균과 홀수 데이터들의 평균 출력하기
// 배열 arr : 1, 2, 3, 4, 5, 6, 7, 8, 9
// 결과:
// 짝수 평균: 5.0
// 홀수 평균: 5.0

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int evenNum = 0;
        int evenCnt = 0;
        int oddNum = 0;
        int oddCnt = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 0){
                evenNum += arr[i];
                evenCnt++;
            }
            if(arr[i] % 2 != 0){
                oddNum += arr[i];
                oddCnt++;
            }
        }

        System.out.println("짝수 평균: " + (float)(evenNum/evenCnt));
        System.out.println("홀수 평균: " + (float)(oddNum/oddCnt));
    }
}
