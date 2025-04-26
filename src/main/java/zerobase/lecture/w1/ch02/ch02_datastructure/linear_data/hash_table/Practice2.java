package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.hash_table;
// 해시 충돌 해결 - 개방 주소법(선형 탐사법)

class MyHashTable2 extends MyHashTable{
    MyHashTable2(int size){
        super(size);
    }
    public void setValue(int key, int data){
        int idx = this.getHash(key);

        // 테이블 꽉 찼을때
        if(this.elemCnt == this.table.length){
            System.out.println("Hash table is full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
            elemCnt++;
        } else {
            // 다른 데이터 들어간 경우 - 충돌하는 상황
            int newIdx = idx; // 충돌난 지점부터
            while (true) { // 반복문을 통해
                // 빈공간 하나씩 구하기
                newIdx = (newIdx + 1) % this.table.length;
                if (this.table[newIdx] == null){
                    this.table[newIdx] = data;
                    elemCnt++;
                    break;
                }
            }
        }
    }
}

public class Practice2 {
    public static void main(String[] args) {
        //        Test code
        MyHashTable2 ht = new MyHashTable2(7);
        ht.setValue(1, 1);
        ht.setValue(3, 3);
        ht.printHashTable();

        ht.setValue(1, 10);
        ht.printHashTable();

        ht.setValue(1, 20);
        ht.setValue(1, 30);
        ht.setValue(1, 40);
        ht.printHashTable();
    }
}
