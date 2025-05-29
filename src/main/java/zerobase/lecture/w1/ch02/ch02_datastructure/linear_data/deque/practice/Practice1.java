package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.deque.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

/* 데이터 재정렬
D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
D_0 -> D_n -> D_1 -> D_n-1 -> .. 순이 되도록 재정렬 하시오

입력데이터: 1 -> 2 -> 3 -> 4 -> 5
출력데이터: 1 -> 5 -> 2 -> 4 -> 3
* */
public class Practice1 {
    public static void reorderData(int[] arr){
        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x->deque.addLast(x));
        System.out.println("deque에 addlast: " + deque);

        while (!deque.isEmpty()){
            result.add(deque.removeFirst());

            if(!deque.isEmpty()){
                result.add(deque.removeLast());
            }
        }

        System.out.println("정렬 전");
        printDeque(arr);
        System.out.println("정렬 후");
        printDeque(result.stream().mapToInt(x -> (int)x).toArray());
//        형태 int, array로 변환
    }

    public static void printDeque(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i] + " -> ");
        }
        System.out.print(arr[arr.length-1]);
        System.out.println();
    }


    public static void main(String[] args) {
//        Test code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr); // 1 5 2 4 3

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2); // 1 7 2 6 3 5 4
    }
}
