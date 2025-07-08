package zerobase.data_structure.ch02.linear_data.queue;

// 배열을 이용한 기본 큐 직접 구현(원형 큐)

class MyQueue2{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyQueue2(int size){
        arr = new int[size+1];
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

//    맨 끝 rear 에 1 을 더하면 마지막 인덱스, 길이로 나눴을 때 0으로 나눠진다면 원형큐 성질로 인해 front와 rear 이 첫번째 데이터를 가르키므로 full
    public boolean isFull(){
        return (this.rear + 1) % this.arr.length == this.front;
    }

//    데이터 추가
    public void enqueue(int data){
        if(this.isFull()){
            System.out.println("Queue is full");
            return;
        }
//        배열이 꽉 차지 않았다면 인덱스 + 1을  더한 값에 길이로 나눠 나온 값의 위치에 데이터 넣기
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

//    데이터 삭제
    public Integer dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue(){
        int start = (this.front + 1) % this.arr.length; // 맨 첫번째
        int end = (this.rear + 1) % this.arr.length; // 맨 끝

        for(int i=start; i != end; i = (i+1)%this.arr.length){
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args) {
//        Test code
        MyQueue2 myQueue = new MyQueue2(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);

        myQueue.printQueue(); // [1, 2, 3, 4, 5]

        System.out.println(myQueue.dequeue()); // 1
        myQueue.printQueue(); // [1, 2, 3, 4, 5]

        System.out.println(myQueue.dequeue()); // 1
        myQueue.printQueue(); // [2, 3, 4, 5]

        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.printQueue(); // 3, 4, 5, 6, 7

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.printQueue();
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.dequeue();

    }
}

