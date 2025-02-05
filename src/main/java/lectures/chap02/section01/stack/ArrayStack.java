package lectures.chap02.section01.stack;

import java.util.EmptyStackException;


public class ArrayStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] stack;
    private int top; // 스택의 상단 인덱스

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        stack = (T[]) new Object[INITIAL_CAPACITY];
        top = -1; // 스택이 비어있는 상태를 나타내는 인덱스
    }

    // 스택에 요소 추가
    public void push(T data) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = data;
    }

    // 스택에서 요소 제거
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T data = stack[top];
        stack[top--] = null; // 메모리 해제를 위해 null로 설정
        return data;
    }

    // 스택의 상단 요소 반환
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return top == -1;
    }

    // 스택의 크기를 동적으로 조정
    private void resize() {
        int newSize = stack.length * 2;
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}

