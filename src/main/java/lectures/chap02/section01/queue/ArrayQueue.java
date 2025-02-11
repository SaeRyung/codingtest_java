package lectures.chap02.section01.queue;

/* 배열 기반 큐 예제 (순환 큐) */
public class ArrayQueue<T> {
    private T[] queue;
    private int front, rear, size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void offer(T data) {
        if (size == queue.length) resize();
        queue[rear] = data;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public T poll() {
        if (isEmpty()) return null;
        T data = queue[front];
        queue[front] = null; // 메모리 해제를 위해 null로 설정
        front = (front + 1) % queue.length;
        size--;
        return data;
    }

    public T peek() {
        return isEmpty() ? null : queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newSize = queue.length * 2;
        @SuppressWarnings("unchecked")
        T[] newQueue = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size;
    }
}

