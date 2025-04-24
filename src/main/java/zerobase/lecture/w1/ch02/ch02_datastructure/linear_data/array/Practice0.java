package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.array;

// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현
// 배열은 초기에 사이즈가 fix 되기 때문에 삽입, 삭제 시 배열 사이즈 변경 필요

public class Practice0 {

    int[] arr;
//    배열 초기 사이즈 설정
    Practice0(int size){
        this.arr = new int[size];
    }

//    배열에 데이터 삽입
    public void insertData(int index, int data){
        if(index < 0 || index > this.arr.length){
            System.out.println("Index Error");
            return;
        }
//        기존 배열 데이터 복사하여 사이즈 큰 배열을 만듬
        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

        for(int i=0; i<index; i++){
            this.arr[i] = arrDup[i];
        }

        for(int i=index+1; i<this.arr.length; i++){
            this.arr[i] = arrDup[i-1];
        }

        this.arr[index] = data;
    }

//    배열에 특정 데이터 삭제
    public void removeData(int data){
        int targetIndex = -1;

//        값이 배열에 있는지 찾기
        for(int i=0; i<this.arr.length; i++){
            if(this.arr[i] == data){
                targetIndex = i;
                break;
            }
        }
//        찾는 데이터가 없다면
        if(targetIndex == -1){
            System.out.println("해당 데이터가 없습니다.");
        } else {
//            기존 데이터 백업
            int[] arrDup = this.arr.clone();
//            사이즈 줄여서 하나 만들기
            this.arr = new int[this.arr.length-1];

            for(int i=0; i<targetIndex; i++){
                this.arr[i] = arrDup[i];
            }

            for(int i=targetIndex; i<this.arr.length; i++){
                this.arr[i] = arrDup[i+1];
            }
        }
    }


    public static void main(String[] args) {

    }


}
