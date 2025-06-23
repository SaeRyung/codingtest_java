package zerobase.lecture.ch02.ch02_datastructure.linear_data_test.deque;

class MyDeque2{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size){
        this.arr = new int[size+1];
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public boolean isFull(){
        return this.front == (this.rear+1) % this.arr.length;
    }

    public void addFirst(int data){
        if(this.isFull()){
            System.out.println("Deque is full");
            return;
        }
        this.arr[this.front] = data;
        this.front = (this.front-1+this.arr.length) % this.arr.length;

    }

    public void addLast(int data){
        if(this.isFull()){
            System.out.println("Deque is full");
            return;
        }
        this.arr[this.rear] = data;
        this.rear = (this.rear+1) % this.arr.length;
    }

    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
        }
        this.front = (this.front+1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
        }
        int data = this.arr[this.rear];
        this.rear = (this.rear-1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque(){

    }

}

public class Practice2 {
    public static void main(String[] args) {
//        Test code
        MyDeque2 myDeque = new MyDeque2(5);

        //        Front 부분 입력
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);
        myDeque.printDeque(); // 3 2 1

//        Rear 부분 입력
        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addLast(30);
        myDeque.printDeque(); // 3 2 1 10 20 30

//        Front 부분 출력
        System.out.println(myDeque.removeFirst()); // 3
        myDeque.printDeque(); // 2 1 10 20 30

//        Rear 부분 출력
        System.out.println(myDeque.removeLast()); // 30
        myDeque.printDeque(); // 2 1 10 20

        System.out.println(myDeque.removeLast()); // 20
        System.out.println(myDeque.removeLast()); // 10
        System.out.println(myDeque.removeLast()); // 1
        System.out.println(myDeque.removeLast()); // Deque is empty
    }
}
