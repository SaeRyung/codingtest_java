package lectures.chap02.section01.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 최소 힙(Min Heap) 예제 */
public class MinHeap<T extends Comparable<T>> { // Comparable 정렬기준 존재
    private List<T> heap = new ArrayList<>(); // 배열로 관리

    // 요소 추가
    public void add(T data) {
        heap.add(data); // 일단 맨 뒤에 요소 추가
        heapifyUp(heap.size() - 1); // 올바른 자리 찾기 위해 위로 올릴지 말지 판단 작업
    }

    // 최소값 추출
    public T extractMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        T min = heap.get(0); // 최소값은 무조건 0번 인덱스
        T last = heap.remove(heap.size() - 1);
        // 0번 인덱스 비어있을 때 관리 코드
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // 최소값 확인
    public T getMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    // 부모 노드로 이동하여 힙 속성 유지 (최소 힙 유지)
    private void heapifyUp(int index) {
        while (index > 0) {
            // 부모 인덱스 계산하여
            int parentIndex = (index - 1) / 2;
            // 비교한 후 바꿀지 유무 판단
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // 자식 노드로 이동하여 힙 속성 유지 (최소 힙 유지)
    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChildIndex;
            }
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    // 인덱스에 해당하는 요소 교환
    // ArrayList 이므로  set 으로 교환
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
