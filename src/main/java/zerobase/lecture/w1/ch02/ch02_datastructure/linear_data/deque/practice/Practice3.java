package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.deque.practice;
/* 데크 변형
기본 데크 구조에서 중간에 데이터를 추가하는 기능을 구현하세요
단 추가적인 자료구조 생성하지 말고 구현

입력 예시)
초기 데크 상태 (size:5)
-> 1, 2, 3, 4
중간입력: 10
결과 데크
-> 1, 2, 10, 3, 4
* */

class MyDeque{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque(int size){
        this.arr = new int[size+1];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (this.rear+1) % this.arr.length == this.front;
    }

    public void addFirst(int data){
        if(this.isFull()){
            System.out.println("Deque is full");
            return;
        }
        this.arr[front] = data;
        this.front = (this.front-1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data){
        if(this.isFull()){
            System.out.println("Deque is full");
            return;
        }
        this.rear = (this.rear + 1)% this.arr.length;
        this.arr[this.rear] = data;
    }

    public void addMiddle(int data){
        if(this.isFull()){
            System.out.println("Deque is full");
            return;
        }
//        데크 원소 몇 개 들어가있는지 세보기
        int elements = this.rear - this.front;
//        음수인 경우, 배열에 원소 갯수를 더해서 양수로 변환
        if(elements < 0){
            elements = this.arr.length + elements;
        }
//        중간 지점 찾기
        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;

        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;
        for(int i = start; i != end; i=(i - 1 + this.arr.length) % this.arr.length){
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data;
        this.rear = (this.rear+1) % this.arr.length;
    }

    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        this.front = (this.front+1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        int data = this.arr[this.rear];
        this.rear = (this.rear-1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque(){
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i+1)%this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
public class Practice3 {
    public static void main(String[] args) {
//        Test code
        MyDeque myDeque = new MyDeque(5);
        myDeque.addLast(1);
        myDeque.addLast(2);
        myDeque.addLast(3);
        myDeque.addLast(4);
        myDeque.printDeque();

        myDeque.addMiddle(10);
        myDeque.printDeque();

        MyDeque myDeque2 = new MyDeque(5);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.addLast(11);
        myDeque2.addLast(12);
        myDeque2.addLast(13);
        myDeque2.printDeque();

        myDeque2.addMiddle(100);
        myDeque2.printDeque();

    }
}
