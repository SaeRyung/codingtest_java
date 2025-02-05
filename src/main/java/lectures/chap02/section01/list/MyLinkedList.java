package lectures.chap02.section01.list;


public class MyLinkedList<T> {

    private Node<T> head;
    private int size;

    /*
       정적 내부 클래스
       독립성 : Node 클래스는 노드를 정의하는 데 필요한 데이터만 포함하고 있으며, 인스턴스 상태와는 직접적인 관계가 없다.
       메모리 효율성 : 정적 내부 클래스는 외부 클래스의 인스턴스 상태에 접근할 수 없기 때문에, 인스턴스 내부 클래스에 비해 메모리 사용이 더 효율적일 수 있다.
       캡슐화 : Node 클래스가 내부에서만 사용되므로, 외부에 노출되지 않도록 숨길 수 있다. 이는 정보 은닉과 캡슐화를 통해 설계를 깔끔하게 유지하는 데 도움이 된다.
    */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(element);
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement;
        if (index == 0) {
            removedElement = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedElement = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

