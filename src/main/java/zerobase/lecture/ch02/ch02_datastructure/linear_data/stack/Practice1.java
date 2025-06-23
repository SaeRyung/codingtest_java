package zerobase.lecture.ch02.ch02_datastructure.linear_data.stack;
// ArrayList 를 이용한 스택 구현
import java.util.ArrayList;

class MyStack1 {
    ArrayList list;

    MyStack1(){
        this.list = new ArrayList();
    }

    // 비어 있는지 확인
    public boolean isEmpty(){
        //ArrayList 의 크기가 0 이면 비어있으니 true 반환, 아니면 false 반환
        if(this.list.size() == 0){
            return true;
        }else {
            return false;
        }
    }

//    ArrayList 의 add 를 사용해 가장 끝쪽에 데이터 추가
    public void push(int data){
        this.list.add(data);
    }

//    ArrayList 삭제
    public Integer pop(){
//        ArrayList 비어있는지 확인하여, 비어있다면 Stack is empty 출력, null 로 반환
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
//        ArrayList 의 가장 끝 가져오기
        int data = (int)this.list.get(this.list.size() - 1);
//        가장 끝을 remove로 제거하기
        this.list.remove(this.list.size() - 1);
//        data 리턴
        return data;
    }

//    peek, 데이터 끝을 가져오기
    public Integer peek(){
//        비어있는 경우 Stack is empty 출력, null 반환
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
//        데이터 존재하면 끝에 데이터 가져오기
        int data = (int)this.list.get(this.list.size() - 1);
        return data;
    }

//    Stack 출력
    public void printStack(){
        System.out.println(this.list);
    }
}

public class Practice1 {
    public static void main(String[] args) {
//        Test code
        MyStack1 myStack1 = new MyStack1();
        System.out.println(myStack1.isEmpty());
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        myStack1.push(4);
        myStack1.push(5);
        myStack1.printStack(); // 1, 2, 3, 4, 5

        System.out.println(myStack1.peek()); // 5
        myStack1.printStack(); // 1, 2, 3, 4, 5

        System.out.println(myStack1.pop()); // 5
        System.out.println(myStack1.pop()); // 4
        myStack1.printStack(); // 1, 2, 3

        System.out.println(myStack1.pop()); // 3
        System.out.println(myStack1.pop()); // 2
        System.out.println(myStack1.pop()); // 1
        myStack1.printStack();

    }
}
