package zerobase.data_structure.ch02.linear_data.linked_list.practice;

// 단방향 연결리스트에서 중복 데이터를 찾아 삭제하세요.
// 입력 연결 리스트 : 1, 3, 3, 1, 4, 2, 4, 2
// 결과 연결 리스트 : 1, 3, 4, 2

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() {}

    LinkedList(Node node){
        this.head = node;
    }

    //    연결 리스트 비어있는지 확인
    public boolean isEmpty() {
//        head가 null인 상태이면 true를 return, 그 외의 경우는 false 출력한다.
        if (this.head == null) {
            return true;
        }
        return false;
    }

    //    연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data) {
//        연결리스트의 head 가 null 이라면, 가장 맨 처음 head에 노드를 새로 생성해서, head에 data를 넣고 next에 null을 넣는다.
        if (this.head == null) {
            this.head = new Node(data, null); // 맨 처음, 새 노드 안에 data 넣는다.
        } else {
//            노드가 있다면
            Node cur = this.head; // 첫 헤드를 가리키도록 보존하고 cur 이 헤드를 가리킬 수 있도록
            while (cur.next != null) {
//                next 가 있을 때까지 이동
                cur = cur.next;
            }
//            끝까지 순회한 후 cur의 next를 들어온 데이터를 가리키도록 설정
            cur.next = new Node(data, null);
        }
    }

    //    연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
//        연결리스트가 비어있다면 List is Empty 출력하고 return
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head; //끝으로 이동해서 지울 노드를 지정
        Node prev = cur; // 지우기 이전 노드를 null로 바꾸기 위한 변수

//        cur을 이동시키면서, prev는 이전 cur을 가리키기 위해 cur을 가리키고, 그 후 cur은 다음 cur을 가리킨다.
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
//        cur이 head를 가리키면, 마지막 데이터이므로  head를 null로 바꿔준다.
        if (cur == this.head) {
            this.head = null;
//            prev의 next 부분도 null로 바꿔준다.
        } else {
            prev.next = null;
        }
    }

    //    연결 리스트에서 데이터 찾기
    public boolean findData(int data) {
//        비어있다면 List is empty 출력하고 return
        if (this.isEmpty()) {
            System.out.println("List is empty");
        }
//        리스트를 순회하면서 데이터 있는지 확인, head로부터 이동을 시키며 데이터 있다면 Data exist 출력
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist");
                return true;
            }
            cur = cur.next;
        }
//        데이터 없으면 Data not found 출력
        System.out.println("Data not found");
        return false;
    }


    //    연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }


}

public class Practice1 {
    public static LinkedList removeDup(LinkedList listBefore){
        LinkedList listAfter = new LinkedList();
//        기존 연결리스트를 순회
        Node cur = listBefore.head;
        while (cur != null){
//            데이터 있는지 없는지 확인, 없다면 삽입, 있다면 중복데이터 안들어가도록
            if(listAfter.findData(cur.data) == false){
                listAfter.addData(cur.data);
            }
            cur = cur.next;
        }
        return listAfter;
    }

    public static void main(String[] args) {
////        Test code
        LinkedList linkedList = new LinkedList();

        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.showData(); // 1 3 3 1 4 2 4 2

        linkedList = removeDup(linkedList);
        linkedList.showData(); // 1 3 4 2

    }
}
