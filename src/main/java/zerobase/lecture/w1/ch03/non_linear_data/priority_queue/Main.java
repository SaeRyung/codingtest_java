package zerobase.lecture.w1.ch03.non_linear_data.priority_queue;
// 비선형 자료구조 - 우선순위 큐
// 연결 리스트를 이용한 우선순위 큐
// 자바 기본 PriorityQueue => 내부적으로 heap 자료구조로 구성

import java.util.*;

/* 우선순위 큐 - enqueue, dequeue
# 우선순위가 높은 데이터가 먼저 나옴(≠FIFO)
- 모든 데이터에 우선순위가 있음
- Dequeue 시, 우선순위가 높은 순으로 나감
- 우선 순위가 같은 경우는 FIFO
# 최소 힙 및 최대 힙의 삽입 삭제와 같음
- enqueue() : 정렬된 배열, 정렬된 연결 리스트: O(N) / 힙 : O(logN)
- dequeue() : 정렬된 배열, 정렬된 연결 리스트: O(1) / 힙 : O(logN)
* */
public class Main {
    public static void enqueue(LinkedList<Integer> list, int data) {
        int idx = list.size(); // 가장 끝 인덱스 받아오기
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > data) {
                idx = i;
                break;
            }
        }
        list.add(idx, data);
    }

    public static Integer dequeue(LinkedList<Integer> list) {
        if(list.size() == 0) {
            return null;
        }
        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args) {
//        연결리스트를 이용한 우선순위 큐
        System.out.println("==== 연결리스트 방식의 우선순위 큐 ====");
        LinkedList<Integer> pqList = new LinkedList<>();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList); // [1, 3, 5, 7, 9]

        System.out.println(dequeue(pqList)); // 1
        System.out.println(dequeue(pqList)); // 3
        System.out.println(pqList); // [5, 7, 9]
        System.out.println();

//        자바 기본 PriorityQueue 사용
        System.out.println("==== 자바 기본 우선순위 큐 ====");
//        우선 순위 : 낮은 숫자 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(9);
        System.out.println(pq); // [1, 3, 5, 7, 9]
//        우선 순위 : 높은 숫자 순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(9);
        System.out.println(pq2); // [9, 7, 3, 1, 5]

    }
}
