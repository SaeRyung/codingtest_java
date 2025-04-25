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
}
public class Practice3 {
}
