package lectures.chap02.section01.stack;

import java.util.EmptyStackException;

public class LinkedListStack<T> {
    private Node<T> top; // 스택의 상단 노드

    // 노드 클래스
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    // 스택에 요소 추가, 가장 위에 추가
    public void push(T data) {
        top = new Node<>(data, top);
    }

    // 스택에서 요소 제거
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T data = top.data;
        top = top.next; //top.next => top 바로 아래 요소를 top으로,
        return data;
    }

    // 스택의 상단 요소 반환
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return top == null;
    }
}
