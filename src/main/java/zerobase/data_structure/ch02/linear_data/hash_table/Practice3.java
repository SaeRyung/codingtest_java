package zerobase.data_structure.ch02.linear_data.hash_table;
// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)

class MyHashTable3 extends MyHashTable{
    MyHashTable3(int size){
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);
        
//        테이블 꽉 찬 상황
        if(this.elemCnt == this.table.length){
            System.out.println("Hash table is full");
            return;
//            넣을 수 있는 경우
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {
            int newIdx = idx; // 기존 충돌 지점으로 초기화
            int cnt = 0; // 충돌 카운트
            while (true){
                newIdx = (newIdx + (int)Math.pow(2, cnt)) % this.table.length; // 2 의 제곱만큼 이동
                if(this.table[newIdx] == null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }
}

public class Practice3 {
    public static void main(String[] args) {
//        Test code
        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100);
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.setValue(1, 400);
        ht.printHashTable();
    }
}
