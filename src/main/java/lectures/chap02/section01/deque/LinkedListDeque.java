package lectures.chap02.section01.deque;

/* 연결 리스트 기반 덱 예제 */
public class LinkedListDeque<T> {
    private Node<T> front; // 덱의 앞쪽 노드
    private Node<T> rear;  // 덱의 뒤쪽 노드

    // 노드 클래스
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // 덱에 요소 추가 (앞쪽)
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, front, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            // 새롭게 추가된 요소 참조
            front.prev = newNode;
            front = newNode;
        }
    }

    // 덱에 요소 추가 (뒤쪽)
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null, rear);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            // 마지막에 있는 데이터 뒤에 추가 후
            rear.next = newNode;
            // 가장 마지막 데이터라고 표현
            rear = newNode;
        }
    }

    // 덱에서 요소 제거 (앞쪽)
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        T data = front.data;
        // 다음값 front로 변경
        front = front.next;
        if (front == null) rear = null;
        else front.prev = null;
        return data;
    }

    // 덱에서 요소 제거 (뒤쪽)
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        T data = rear.data;
        rear = rear.prev;
        if (rear == null) front = null;
        else rear.next = null;
        return data;
    }

    // 덱의 앞쪽 요소 반환
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        return front.data;
    }

    // 덱의 뒤쪽 요소 반환
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Deque is Empty");
        return rear.data;
    }

    // 덱이 비어있는지 확인
    public boolean isEmpty() {
        return front == null;
    }
}

