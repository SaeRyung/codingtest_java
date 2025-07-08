package zerobase.data_structure.ch03.non_linear_data.heap;
// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

/* 힙(Heap)
# 완전 이틴 트리 형태 : 마지막 레벨(왼쪽) 제외하고 다 차있는 트리 형태
- 중복 값 허용
- 반 정렬 상태
# 최소값 또는 최대값을 빠르게 찾아내는데 유용한 자료구조
- 최소 힙(Min Heap) : 부모 노드의 키가 자식 노드의 키보다 작거나 같은 형태, 형제끼리는 값 기준이 없어서 좌,우 클 수 도 있고 작을수도 있다.
[삽입]
1. 트리의 가장 끝 위치에 데이터 삽입
2. 부모 노드와 키 비교한 후 작을 경우 부모 자리와 교체(반복)
[삭제]
1. 최상위 노드 반환 및 삭제
2. 가장 마지막 위치의 노드를 취상위 노드로 위치 시킴
3. 자식 노드 중 작은 값과 비교 후 부모 노드가 더 크면 자리 교체(반복)
- 최대 힙(Max Heap) : 부모 노드의 키가 자식 노드의 키보다 크거나 같은 형태
=> 배열로 많이 구현된다.
* */

import java.util.ArrayList;
// 최소 힙
class MinHeap{
    ArrayList<Integer> heap;

    public MinHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0); // 1번부터 시작할 수 있도록 데이터 1개 삽입 - 코드 가독성, 계산 효율 높이기
    }

//    데이터 삽입
    public void insert(int data) {
        heap.add(data); // 맨 먼저 가장 끝에 삽입하기

        int cur = heap.size() - 1; // 방금 넣은 데이터의 인덱스 위치 구하기
        while(cur > 1 && heap.get(cur / 2) > heap.get(cur)){
            //0번째일 경우 맨 처음 넣었던 더미데이터이므로 1보다 크거나, cur/2 를 통해 자기자신 부모 위치의 값이 지금 들어온 값보다 크다면 위로 올리기
            int parentVal = heap.get(cur / 2); // 부모 값
            heap.set(cur / 2, data); // 방금 들어온 데이터 부모에게 넘겨주기
            heap.set(cur, parentVal); // 부모의 데이터 넘겨주기

            // 부모 노드의 위치를 구해 반복할 수 있도록
            cur /= 2;
        }
    }

//    데이터 삭제
    public Integer delete() {
        if(heap.size() == 1){ // Heap의 크기가 1인 경우 더미데이터만 존재하므로, null값 반환
            System.out.println("Heap is empty");
            return null;
        }

        int target = heap.get(1); // 데이터 하나 먼저 꺼내기

        heap.set(1, heap.get(heap.size() -1)); // 1번 위치에 마지막 데이터 꺼내오기
        heap.remove(heap.size() - 1);

//        가장 위에 올린 데이터가 minHeap 기준에 적합한지 판단하기
        int cur = 1;
        while(true) {
//            해당 케이스가 나올때까지 반복문
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()){ // 오른쪽 자식 존재 여부 확인, 존재한다면 왼쪽 자식 반드시 존재(완전 이진 트리)
                // 두 자식 중 더 작은 자식 선택
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if(leftIdx < heap.size()){ // 자식 노드가 하나인 경우, 왼쪽 자식만 존재하는 경우
                targetIdx = cur * 2; //
            } else { // 부모 노드만 있는 경우
                break;
            }

//        위에서 선정한 타겟값 비교
            if(heap.get(cur) < heap.get(targetIdx)){
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target;
    }

//    출력하기
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
//        Test code
        MinHeap minHeap = new MinHeap();
        System.out.println("==== 데이터 삽입 ====");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree(); // 10 40 30
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree(); // 10 40 30 50 60 70
        minHeap.insert(20);
        minHeap.printTree(); // 10 40 20 50 60 70 30
        minHeap.insert(30);
        minHeap.printTree(); // 10 30 20 40 60 70 30 50

        System.out.println();
        System.out.println("==== 데이터 삭제 ====");
        System.out.println("삭제 : " + minHeap.delete()); // 삭제 : 10
        minHeap.printTree(); // 20 30 30 40 60 70 50
        System.out.println("삭제 : " + minHeap.delete()); // 삭제 : 20
        minHeap.printTree(); // 30 30 50 40 60 70
        System.out.println("삭제 : " + minHeap.delete()); // 삭제 : 30
        minHeap.printTree(); // 30 40 50 70 60
    }
}
