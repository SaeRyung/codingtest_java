package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.deque;

// 선형자료구조 - 데크

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();

//        Front 부분 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);

//        Rear 부분 입력
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);

//        Front 부분 출력
        System.out.println(deque.removeFirst());
        System.out.println(deque);

//        Rear 부분 출력
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);

//        차이점
        System.out.println(deque.pollLast()); // 아무것도 없어서 null 리턴
        System.out.println(deque.removeLast()); // 예외발생, 에러
    }
}
