package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.queue.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/* 카드 섞기
 1부터 N까지의 번호로 구성된 N장의 카드가 있다.
 1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태로 카드가 순서대로 쌓여있다.
 아래의 동작을 카드 한 장만 남을 때까지 반복했을 때, 가장 마지막 남는 카드 번호를 출력하시오
 1. 가장 위의 카드는 버린다.
 2. 그 다음 위의 카드는 쌓여 있는 카드의 가장 아래에 다시 넣는다.

 N = 4
 결과: 4

 N = 7
 결과: 6
*/
public class Practice1 {

    public static int findLastCard(int N) {
        Queue queue = new LinkedList();

        IntStream.range(1, N+1).forEach(x -> queue.add(x));

        while(queue.size() > 1){
            queue.poll();
            System.out.println(queue);
            int data = (int)queue.poll();
            queue.add(data);

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
