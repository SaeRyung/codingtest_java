package zerobase.data_structure.ch02.linear_data_test.linked_list;

// 연습용
// 단순 연결 리스트 - 중간에 추가, 삭제

// 단순 연결 리스트 구현
// 중간에 추가, 삭제하는 로직 구현

class LinkedList2 extends LinkedList {
    LinkedList2(Node node) {
        this.head = node;
//        super(node); 와 동일하다.
    }

    //    **연결 리스트에 데이터 추가
//    before_data 가 null인 경우, 가장 뒤에 추가
//    before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
//    추가할 데이터, beforData 앞에 추가할지 뒤에 추가할지 나눠서 구현
    public void addData(int data, Integer beforeData) {
        // head에 값이 없다면 새로운 Node 추가
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
//            before 데이터에 값이 없다면
//            cur 데이터에 head를 넣고
//            cur.next 의 null 아닌 부분을 찾고
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
//            cur의 next 값이 null이면 해당 데이터 넣기
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node pre = cur;
            while (cur != null) {
//              cur이 null 이 아닌 조건
//              before 데이터와 cur 데이터가 일치하면
                if (cur.data == beforeData) {
//                    cur이 head 값이면
                    if (cur == this.head) {
//                        head에 방금 들어온 data를 노드로 만들어서 할당한다. head는 그 다음 데이터로 연결
                        this.head = new Node(data, this.head);
                    } else {
//                        중간에 들어온다면 cur을 받은 pre.next에 new Node를 생성하고 뒤에 cur 연결
                        pre.next = new Node(data, cur);
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    //    **데이터에 해당하는 노드 지우기
    public void removeData(int data) {
//        list가 비어있다면 List is empty 출력
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
//                첫 번째 노드를 삭제하는 경우 다음 cur을 바로 head로 바꾼다.
        Node cur = this.head;
        Node prev = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                return;
            }
//                중간이나 마지막 노드 삭제하는 경우, 이전 node를 다음 node로 바꿔준다.
//            삭제 후 메서드 종료
            prev = cur;
            cur = cur.next;
        }
    }


    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}


public class Practice1 {
    public static void main(String[] args) {
//        Test code
        LinkedList2 myList = new LinkedList2(new Node(1, null));
        myList.showData(); // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
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