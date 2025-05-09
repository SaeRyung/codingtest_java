package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.hash_table;
// 해시 충돌 해결 - 개방 주소법 (이중 해싱)
class MyHashTable4 extends MyHashTable{
    int c; // 해시테이블 보다 작은 소수, 효율적인 효과 위한 변수

    MyHashTable4(int size){

        super(size);
        this.c = this.getHashC(size);
    }

    public int getHashC(int size){
        int c = 0;

        if(size <= 2){
            return size;
        }
//         소수판별
        for(int i=size-1; i>2; i--){
            boolean isPrime = true;
            for(int j=2; j<i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                c = i;
                break;
            }
        }
        return c;
    }

//    두번째 해시 함수 구하기
    public int getHash2(int key){
        int hash = 1 + key % this.c;
        return c;
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("Hast table is full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else { // 충돌 난 지점
            int newIdx = idx;
            int cnt = 1;
            while (true) {
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
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

public class Practice4 {
    public static void main(String[] args) {
//        Test Code
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }
}
