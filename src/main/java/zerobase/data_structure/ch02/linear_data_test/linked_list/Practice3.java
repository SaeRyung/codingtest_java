package zerobase.data_structure.ch02.linear_data_test.linked_list;

// 원형 연결 리스트 공부
class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.tail;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    //    연결리스트에 데이터 추가
    public void addData(int data, Integer beforeData) {
//        head 가 null인 경우
        if (this.head == null) {
            NodeBi nodeBi = new NodeBi(data, null, null);
            this.head = nodeBi;
            this.tail = nodeBi;
            nodeBi.next = nodeBi;
            nodeBi.prev = nodeBi;
            //    before_data 가 null인 경우, 가장 뒤에 추가
        } else if (beforeData == null) {
            /* 가장 끝에 데이터 추가하는 경우
            원형리스트이므로 처음과 끝이 연결되도록 head 와 tail 을 넣어준다.*/
            NodeBi nodeBi = new NodeBi(data, this.head, this.tail);
            this.tail.next = nodeBi;
            this.head.prev = nodeBi;
            this.tail = nodeBi;
//            beforedata 가 null이 아닌 경우 cur, pre에 값 넣어준다.
        } else {
            NodeBi cur = this.head;
            NodeBi pre = this.tail;
//            반복문, cur의 data 값 확인
            do {
//                cur.data 가 before와 같을 때
                if (cur.data == beforeData) {
//                    cur 값이 head 와 같은 경우
                    if (cur == this.head) {
                        NodeBi nodeBi = new NodeBi(data, this.head, this.tail);
                        this.tail.next = nodeBi;
                        this.head.prev = nodeBi;
                        this.tail = nodeBi;
//                    cur.data 가 중간에 추가되는 경우
                    } else {
                        NodeBi nodeBi = new NodeBi(data, cur, pre);
                        pre.next = nodeBi;
                        cur.prev = nodeBi;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while (cur != this.head);
        }
    }
//        원형 데이터 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
//        삭제를 위한 기본 구조 cur, pre
        NodeBi cur = this.head; // 현재 검사 중인 노드
        NodeBi pre = cur; // 현재 노드의 이전 노드
//        cur 이 null 이 아닐 때
        while (cur != null){
//            cur의 데이터가 data와 같을때
            if(cur.data == data){
//                cur이 head, tail => 데이터가 한 개일 때
                if(this.head == cur && this.tail == cur){
                    this.head = null;
                    this.tail = null;
                    /* 삭제 데이터가 head 일 경우
                    * cur.next 값의 pre -> head.prev
                    * head 는 cur.next
                    * tail.next 는 head*/
                } else if (cur == this.head) {
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                    /* 삭제 데이터가 tail 일 경우
                    pre.next 값 -> tail.prev
                    tail -> pre
                    head.prev -> tail
                    * */
                } else{
                    pre.next = this.tail.prev;
                    this.tail = pre;
                    this.head.prev = this.tail;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        NodeBi cur = this.head;
        while (cur.next != this.head) { // 끝이 null 이 아닌 자기 자신
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
}

public class Practice3 {
    public static void main(String[] args) {
//        Test code
        CircularLinkedList myList = new CircularLinkedList(new NodeBi(1, null, null));

        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData(); // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData(); // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData(); // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();
    }
}
