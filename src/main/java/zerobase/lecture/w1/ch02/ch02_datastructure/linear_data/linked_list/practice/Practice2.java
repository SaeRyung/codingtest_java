package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.linked_list.practice;
/* Palindrome 연결 리스트
추가 자료구조 없이 연결 리스트만으로 풀어보기
Palindroem : 앞으로 읽어도 뒤로 읽어도 같은 문자열

입력 예시
입력 연결 리스트 : 1, 3, 5, 3, 1
결과: true

입력 연결 리스트: 3, 5, 5, 3
true

입력 연결 리스트: 1, 3, 5, 1
결과: false
* */
public class Practice2 {
    public static boolean checkPalindrome(LinkedList list){
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

//        cnt 리스트 길이
//        연결리스트 생성
        int cnt = 0;
        while (cur != null){
            cnt++;
            right = cur;
            cur = cur.next;
        }
//        prevRight , 절반 비교 하면 체크할 수 있기 때문에 절반만 반복문
//        다르면 false
        Node prevRight = right;
        for (int i = 0; i < cnt/2; i++) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = left;
//            right 를 왼쪽 데이터로 이동
            while (right.next != prevRight){
                right = right.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Test code
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(5);
        linkedList.addData(3);
        linkedList.addData(1);
        System.out.println(checkPalindrome(linkedList));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(3);
        linkedList2.addData(5);
        linkedList2.addData(5);
        linkedList2.addData(3);
        System.out.println(checkPalindrome(linkedList2));

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addData(1);
        linkedList3.addData(3);
        linkedList3.addData(5);
        linkedList3.addData(1);
        System.out.println(checkPalindrome(linkedList3));
    }
}
