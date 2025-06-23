package zerobase.lecture.ch02.ch02_datastructure.linear_data.queue.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/* 카드 섞기
 1부터 N까지의 번호로 구성된 N장의 카드가 있다.
 1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태로 카드가 순서대로 쌓여있다.
 아래의 동작을 카드 한 장만 남을 때까지 반복했을 때, 가장 마지막 남는 카드 번호를 출력하시오
 1. 가장 위의 카드는 버린다.
 2. 그 다음 위의 카드는 쌓여 있는 카드의 가장 아래에 다시 넣는다.

 1 2 3 4 => 1을 버리고 2 마지막 => 3 4 2 => 3을 버리고 4를 마지막 => 2 4 => 2를 버리고 남은 카드 4

 N = 4
 결과: 4

 N = 7
 결과: 6
*/
public class Practice1 {

    public static int findLastCard(int N) {
        Queue queue = new LinkedList();

//        queue 에 값 넣기
        IntStream.range(1, N+1).forEach(x -> queue.add(x));
        System.out.println(queue);

//        반복문 실행
        while(queue.size() > 1){
//            맨 처음 장 버리기
            queue.remove();
            System.out.println(queue);
//            버린 값, 다시 뒤에 넣기
            int data = (int)queue.remove();
            queue.add(data);
            System.out.println(queue);

        }
        return (int)queue.poll();
    }

    public static void main(String[] args) {
//        Test code
        System.out.println(findLastCard(4)); // 4
        System.out.println(findLastCard(7)); // 6
        System.out.println(findLastCard(9)); // 2
    }
}
