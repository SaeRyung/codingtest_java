package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.array;

// 배열 arr에서 target 에 해당하는 값의 인덱스를 출력
// 해당 값이 여러 개인 경우 가장 큰 인덱스 출력

// 배열 arr : {1, 1, 100, 1, 1, 1, 100}
// target = 100
// 결과 : 6

public class Practice2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        int target = 100;
        int idx = -1;
        for(int i=0; i<arr.length; i++){
            if(target == arr[i]){
                if(idx < i){
                    idx = i;
                }
            }
        }
        if(idx >= 0){
            System.out.println("결과: " + idx);
        }else{
            System.out.println("찾는 타겟이 없습니다.");
        }
    }
}
