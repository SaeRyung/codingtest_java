package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.array;

import java.util.Arrays;

class MyArrayy {
    int[] arr;

    //    배열 초기 사이즈 설정
    MyArrayy(int size) {
        this.arr = new int[size];
    }

    //    **배열에 데이터 삽입
    public void insertData(int index, int data) {
//        인덱스가 0보다 작거나 배열 길이보다 인덱스가 큰 경우는 연속적이지 않은 위치에 데이터를 추가하므로 Index Error 예외처리
        if (index < 0 || this.arr.length < index) {
            System.out.println("Index Error");
            return;
        }
//        기존 배열 데이터 복사한 후 사이즈 큰 배열을 만듬
        int[] newArr = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

//        사이즈 큰 배열에 0부터 데이터 추가 위치까지, 데이터 할당
        for (int i = 0; i < index; i++) {
            this.arr[i] = newArr[i];
        }
//        데이터 추가 후 위치부터 배열 위치까지 데이터 할당
        for (int i = index + 1; i < arr.length; i++) {
            this.arr[i] = newArr[i - 1];
        }

//        추가된 위치에 데이터 추가
        this.arr[index] = data;
    }

    //    **배열에 특정 데이터 삭제
    public void removeData(int data) {
        // 맨처음 아무것도 찾은 게 없다는 의미로 -1
        int target = -1;
//        값이 기존 배열에 있는지 찾기, 배열 순회 후 삭제 데이터 확인되면 타겟인덱스에 데이터 위치 넣기
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] == data) {
                target = i;
                break;
            }
        }
//        찾는 데이터가 없다면 타겟이 -1 이므로 해당 데이터 없다고 출력
        if (target == -1) {
            System.out.println("해당 데이터가 존재하지 않습니다.");
        } else {
            //            찾는 데이터가 존재한다면
//            기존 데이터 백업
            int[] newArr = this.arr.clone();
//            사이즈 줄여서 하나 만들기
            this.arr = new int[this.arr.length - 1];
//            타겟 위치까지 순회하여
            for (int i = 0; i < target; i++) {
//            삭제하려는 데이터 빼고 그 후에 데이터 넣기
                this.arr[i] = newArr[i];
            }
            for (int i = target; i < this.arr.length; i++) {
                this.arr[i] = newArr[i+1];
            }
        }
    }
}


public class Test {
    public static void main(String[] args) {
//        Test code
        int size = 5;
        MyArrayy myArray = new MyArrayy(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr)); //[1, 2, 3, 4, 5]

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr)); //[10, 2, 3, 4, 5]

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr)); //[10, 2, 20, 3, 4, 5]

        myArray.insertData(-1, 0); // Index Error

        myArray.removeData(7);
        System.out.println(Arrays.toString(myArray.arr)); // 해당 데이터가 없습니다.

        myArray.removeData(3);
        System.out.println(Arrays.toString(myArray.arr)); //[10, 2, 20, 4, 5]
    }
}
