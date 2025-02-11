package lectures.chap02.section01.deque;

public class MyArrayDeque<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] deque;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public MyArrayDeque() {
        deque = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Deque의 크기 확인
    public int size() {
        return size;
    }

    // Deque가 비어 있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 앞에 요소 추가
    public void addFirst(T data) {
        if (size == deque.length) {
            resize();
        }
        front = (front - 1 + deque.length) % deque.length;
        deque[front] = data;
        size++;
    }

    // 뒤에 요소 추가
    public void addLast(T data) {
        if (size == deque.length) {
            resize();
        }
        rear = (rear + 1) % deque.length;
        deque[rear] = data;
        size++;
    }

    // 앞에서 요소 제거
    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        T data = deque[front];
        deque[front] = null;
        front = (front + 1) % deque.length;
        size--;
        return data;
    }

    // 뒤에서 요소 제거
    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        T data = deque[rear];
        deque[rear] = null;
        rear = (rear - 1 + deque.length) % deque.length;
        size--;
        return data;
    }

    // 앞의 요소 반환
    public T getFirst() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        return deque[front];
    }

    // 뒤의 요소 반환
    public T getLast() {
        if (isEmpty()) throw new IllegalStateException("Deque is empty");
        return deque[rear];
    }

    // 크기 조정
    private void resize() {
        int newSize = deque.length * 2;
        @SuppressWarnings("unchecked")
        T[] newDeque = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newDeque[i] = deque[(front + i) % deque.length];
        }
        deque = newDeque;
        front = 0;
        rear = size - 1;
    }
}

