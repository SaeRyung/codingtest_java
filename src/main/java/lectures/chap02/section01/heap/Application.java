package lectures.chap02.section01.heap;

import java.util.PriorityQueue;

/* Java Collection Framework에는 heap을 직접 지원하는 클래스는 없지만
* PriorityQueue 클래스를 이용하여 heap을 구현할 수 있다. */
public class Application {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대힙으로 조회하고 싶으면 기준값 바꾸기
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        // 요소 추가
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(8);

        // 최소값 조회
        System.out.println(minHeap.peek());

        // 최소값 제거
        System.out.println(minHeap.poll());

        // 제거 후 최소값 조회
        System.out.println(minHeap.peek());
    }
}
