package zerobase.lecture.ch02.ch02_datastructure.linear_data.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Object> queue = new LinkedList<>();
//        Queue queue = new Queue > Queue는 인터페이스이기 때문에 포함된 메서드 전부 오버라이딩을 해야한다.
//        LinkedList로 다형성을 할당해서 사용 가능

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.poll()); // 최상위 요소
        System.out.println(queue);

        System.out.println(queue.poll()); // 확인
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.contains(3));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue); // []
        System.out.println(queue.poll()); // null
//        queue.remove 는 비었을 때 error, queue.poll 은 null 반환
    }
}
