package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.stack;
// 배열을 이용한 기본 스택 직접 구현
class MyStack2{
    int[] arr;
    int top = -1; // 마지막 데이터 위치

    MyStack2(int size){
        arr = new int[size];
    }

//    배열 비어있는지 확인, top 이 -1 이면 true 반환, 아니면 false
    public boolean isEmpty(){
        if(this.top == -1){
            return true;
        } else{
            return false;
        }
    }

//    배열 가득 채워져있는지 확인, 배열은 사이즈가 고정되어 있으므로 확인한다.
//    가득 차있다면 true 반환, 아니면 false 출력
    public boolean isFull(){
        if(this.top == this.arr.length-1){
            return true;
        } else{
            return false;
        }
    }

//    데이터 넣기
    public void push(int data){
//        꽉 찼다면 Stack is full 출력
        if(this.isFull()){
            System.out.println("Stack is full");
            return;
        }
//        가득 차있지 않다면 top +1 후, 그 위치에 데이터 할당
        this.top += 1;
        this.arr[this.top] = data;
    }

//    데이터 삭제
    public Integer pop(){
//        데이터 비어있는지 확인, 비어있다면 Stack is empty 출력, null 반환
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
//        pop 할 데이터를 가져오기, top -1,  data 리턴
//        사실상 데이터를 남아있으나 top 으로 해당 데이터 접근을 제한하기
        int data = this.arr[this.top];
        this.top -= 1;
        return data;
    }

//    peek 할 데이터
    public Integer peek(){
//        배열 비어있는지 확인, null 반환
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
//        해당 데이터 return 만 하기
        return this.arr[this.top];
    }

//    배열 출력
    public void printStack(){
        for(int i=0; i<this.top+1; i++){
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args) {
//        Test code
        MyStack2 myStack = new MyStack2(5);
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.printStack(); // 1, 2, 3, 4, 5

        System.out.println(myStack.peek()); // 5
        myStack.printStack(); // 1, 2, 3, 4, 5

        System.out.println(myStack.pop()); // 5
        System.out.println(myStack.pop()); // 4
        myStack.printStack(); // 1, 2, 3

        System.out.println(myStack.pop()); // 3
        System.out.println(myStack.pop()); // 2
        System.out.println(myStack.pop()); // 1
        myStack.printStack();

    }
}
