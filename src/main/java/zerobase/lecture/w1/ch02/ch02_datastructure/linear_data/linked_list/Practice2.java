package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.linked_list;
// 양방향 연결 리스트(Doubly Linked List) 구현
// head → [prev|데이터|next] ↔ [prev|데이터|next] ↔ [prev|데이터|next] ← tail

class NodeBi{
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(int data, NodeBi next, NodeBi prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

// 양방향 연결리스트 관리 클래스
class DoublyLinkedList extends LinkedList{
    NodeBi head; // 가장 처음
    NodeBi tail; // 가장 끝

    DoublyLinkedList(NodeBi node){
//        처음에는 헤드와 테일이 같은 노드를 가리킨다.
        this.head = node;
        this.tail = node;
    }

//   관리하는 노트 타입이 변경되었기에 빈 노드 확인하는 메서드 새로 만들기
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

//    데이터 추가 메서드
    public void addData(int data, Integer beforeData){
        // 노드가 아무것도 없다면
        if(this.head == null){
//           새 노드를 생성하고 next와 prev는 null을 가리킴
            this.head = new NodeBi(data, null, null);
//            tail 이 head 를 가리킴
            this.tail = this.head;
//            데이터 추가 위치가 null 이면 제일 끝에 데이터 추가
//            추가 데이터가 null 인 경우
        } else if (beforeData == null) {
//            tail을 관리하기 때문에 tail 을 이용해서 끝에 데이터 추가한다.
            this.tail.next = new NodeBi(data, null, this.tail);
//            새로 데이터가 들어왔기 때문에 tail 을 바꿔준다.
            this.tail = this.tail.next;
//            추가 데이터가 있는 경우
        } else {
            // 찾을대상 cur, 뒤의 대상은 pre
            NodeBi cur = this.head;
            NodeBi pre = cur;
            // 찾을 대상이 null 이 아닐때까지 반복문
            while(cur != null){
                // cur의 data가 beforeData 일때
                if(cur.data == beforeData){
//                    cur이 head 라면
                    if(cur == this.head){
                        this.head = new NodeBi(data, this.head, null);
//                        양방향 연결 부분
                        this.head.next.prev = this.head;
                    } else {
//                       cur이 헤드가 아닐 때, 중간에 데이터 추가될 때
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }
//    데이터 삭제 메서드
    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null){
            if(cur.data == data) {
//                노드가 하나인 경우
//                cur 이 head 와 tail 을 가리키면 data가 하나이므로 모두 null 로 바꿔준다.
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                    //                    노드가 헤드인 경우, 노드가 하나 초과인 경우
                } else if (cur == this.head) {
//                    head 를 다음으로 넘겨주고, 이전껄 null 처리
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.tail) {
//                    노드가 가장 끝인 경우,
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
//                    중간 노드 삭제 경우
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

//    데이터 출력 메서드
    public void showData(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
//        리스트 순회하면서 데이터 모두 출력
        NodeBi cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

//    역순 데이터 출력 메서드
    public void showDataFromTail(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        NodeBi cur = this.tail;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();

    }

}

public class Practice2 {
    public static void main(String[] args) {
//        Test code
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData(); // 1

        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail(); // 5 4 3 2 1

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData(); // 100 1 200 2 300 3 400 4 500 5
        myList.showDataFromTail();

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData(); // 1 2 3 4 5
        myList.showDataFromTail();

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData(); //List is empty
        myList.showDataFromTail(); //List is empty
    }
}
