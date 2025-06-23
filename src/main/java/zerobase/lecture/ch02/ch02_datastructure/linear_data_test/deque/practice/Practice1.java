package zerobase.lecture.ch02.ch02_datastructure.linear_data_test.deque.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

public class Practice1 {
    public static void reorderData(int[] arr){
        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(i -> deque.addLast(i));
        System.out.println(deque);
    }

    public static void main(String[] args) {
//        Test code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr); // 1 5 2 4 3

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2); // 1 7 2 6 3 5 4
    }
}
