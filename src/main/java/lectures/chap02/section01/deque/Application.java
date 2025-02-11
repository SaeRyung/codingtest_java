package lectures.chap02.section01.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/* Java Collection Framework에서는 Deque 인터페이스와 이를 구현한 클래스가 있다.
* 배열 기반의 동적 큐인 ArrayDeque 클래스를 활용해보자. */
public class Application {

    public static void main(String[] args){
        Deque<Integer> deque = new ArrayDeque<>();

        // 요소 추가
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(4);

        // 요소확인
        System.out.println(deque.getFirst());
        System.out.println(deque.peekFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peekLast());

        // 요소 제거
        System.out.println(deque.removeFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.pollLast());
    }
}
