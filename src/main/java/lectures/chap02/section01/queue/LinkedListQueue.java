package lectures.chap02.section01.queue;

/* 연결 리스트 기반 큐 예제 */
public class LinkedListQueue<T> {
    private Node<T> front; // 큐의 앞쪽 노드
    private Node<T> rear;  // 큐의 뒤쪽 노드

    // 노드 클래스
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    // 큐에 요소 추가
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // 큐에서 요소 제거
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    // 큐의 앞쪽 요소 반환
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return front.data;
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return front == null;
    }
}

