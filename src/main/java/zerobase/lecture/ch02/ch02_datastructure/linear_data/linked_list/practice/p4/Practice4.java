package zerobase.lecture.ch02.ch02_datastructure.linear_data.linked_list.practice.p4;
/* 연결리스트 배열 사용 연습

주어진 문자열 배열을 연결리스트 배열로 관리하는 코드를 작성하시오
관리 규칙은 다음과 같다.
각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기
* */

import java.util.HashSet;

class Node {
    String data;
    Node next;

    Node() {
    }

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;
    char alphabet;

    LinkedList() {}
    LinkedList(Node node, char alphabet){
        this.head = node;
        this.alphabet = alphabet;
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
    public void addData(String data) {
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
    public void removeData(String data) {
//        연결리스트가 비어있다면 List is Empty 출력하고 return
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head; //끝으로 이동해서 지울 노드를 지정
        Node prev = cur; // 지우기 이전 노드를 null로 바꾸기 위한 변수
        while (cur != null){
            if(cur.data.equals(data)){
                if(cur == this.head){
                    this.head = cur.next;
                } else{
                    prev.next = cur.next;
                }
                break;
            }
        }
    }

    //    연결 리스트에서 데이터 찾기
    public boolean findData(String data) {
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
public class Practice4 {
    public static void dataCollect(String[] data){
//        배열들 사이에서 골라내는 작업
        HashSet<Character> set = new HashSet<>();

        for(String item : data){
            set.add(item.toCharArray()[0]);
        }
        System.out.println(set);

        Character[] arr = set.toArray(new Character[0]);
        LinkedList[] linkedLists = new LinkedList[set.size()];
        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList(null, arr[i]);
        }
        for(String item : data){
            for(LinkedList list : linkedLists){
                if(list.alphabet == item.toCharArray()[0]){
                    list.addData(item);
                }
            }
        }
        for(LinkedList list : linkedLists){
            System.out.println(list.alphabet + " : ");
            list.showData();
        }
    }

    public static void main(String[] args) {
//        Test code
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry"};
        dataCollect(input);
        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", "crab"};
        dataCollect(input2);
    }
}
