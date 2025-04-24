package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.stack;
// ArrayList 를 이용한 스택 구현
import java.util.ArrayList;

class MyStack1 {
    ArrayList list;

    MyStack1(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        if(this.list.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    public void push(int data){
        this.list.add(data);
    }

    public Integer pop(){
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public Integer peek(){
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        int data = (int)this.list.get(this.list.size() - 1);
        return data;
    }

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
