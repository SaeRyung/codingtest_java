package zerobase.data_structure.ch02.linear_data.array;

// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현
// 배열은 초기에 사이즈가 fix 되기 때문에 삽입, 삭제 시 배열 사이즈 변경 필요

import java.util.Arrays;

class MyArray {
    int[] arr;

    //    배열 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];
    }

    //    **배열에 데이터 삽입
    public void insertData(int index, int data) {
//        인덱스가 0보다 작거나 배열 길이보다 인덱스가 큰 경우는 연속적이지 않은 위치에 데이터를 추가하므로 Index Error 예외처리
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;
        }
//        기존 배열 데이터 복사한 후 사이즈 큰 배열을 만듬
        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

//        사이즈 큰 배열에 0부터 데이터 추가 위치까지, 데이터 할당
        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }
//        데이터 추가 후 위치부터 배열 위치까지 데이터 할당
        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }

//        추가된 위치에 데이터 추가
        this.arr[index] = data;
    }

    //    **배열에 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1; // 맨처음 아무것도 찾은 게 없다는 의미로 -1

//        값이 기존 배열에 있는지 찾기, 배열 순회 후 삭제 데이터 확인되면 타겟인덱스에 데이터 위치 넣기
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == data) {
                targetIndex = i;
                break;
            }
        }
//        찾는 데이터가 없다면 타겟이 -1 이므로 해당 데이터 없다고 출력
        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else {
//            찾는 데이터가 존재한다면
//            기존 데이터 백업
            int[] arrDup = this.arr.clone();
//            사이즈 줄여서 하나 만들기
            this.arr = new int[this.arr.length - 1];

//            타겟 위치까지 순회하여
            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];
            }
//            삭제하려는 데이터 빼고 그 후에 데이터 넣기
            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }
}

    public class Practice0 {
        public static void main(String[] args) {
//        Test code
            int size = 5;
            MyArray myArray = new MyArray(size);

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
