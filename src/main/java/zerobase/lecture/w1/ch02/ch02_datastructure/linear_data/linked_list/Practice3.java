package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.linked_list;
// 원형 연결 리스트 (Circular Linked List)구현

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node){
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.tail;
// 다시 자기 자신으로 순환할 수 있는 형태
    }
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }
//    연결리스트에 데이터 추가
//    before_data 가 null인 경우, 가장 뒤에 추가
//    before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData){
        if(this.head == null){
            NodeBi newNodeBi = new NodeBi(data, null, null);
            this.head = newNodeBi;
            this.tail = newNodeBi;
            newNodeBi.next = newNodeBi;
            newNodeBi.prev = newNodeBi;
        } else if (beforeData == null) { // 가장 끝에 데이터 추가하는 경우
            NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
            this.tail.next = newNodeBi;
            this.head.prev = newNodeBi;
            this.tail = newNodeBi;
        } else{
//            tail 뒤에 추가되어서 이동되는 부분
            NodeBi cur = this.head;
            NodeBi pre = cur;
//            beforeData에 값이 들어온 경우
            do{
                if(cur.data == beforeData){
                    if(cur == this.head){
                        NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
                        this.tail.next = newNodeBi;
                        this.head.prev = newNodeBi;
                        this.head = newNodeBi;
                    } else {
//                        노드가 중간에 추가되는 경우
                        NodeBi newNodeBi = new NodeBi(data, cur, pre);
                        pre.next = newNodeBi;
                        cur.prev = newNodeBi;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while (cur != this.head);
        }
    }

//    연결리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data){
        if(this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
//        삭제를 위한 기본 구조
        NodeBi cur = this.head;
        NodeBi pre = this.tail;

        do{
            if(cur.data == data){
                if(cur == this.head && cur == this.tail){
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) { //헤드일 경우
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                } else if (cur == this.tail) { // 끝 노드일 경우
                    pre.next = this.tail.next;
                    this.tail = pre;
                    this.head.prev = this.tail;
                } else{ // 중간일때
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                return;
            }
            pre = cur;
            cur = cur.next;
        } while (cur != this.head);
    }
    public void showData(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        NodeBi cur = this.head;
        while (cur.next != this.head){ // 끝이 null 이 아닌 자기 자신
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
