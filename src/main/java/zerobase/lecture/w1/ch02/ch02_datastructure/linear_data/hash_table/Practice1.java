package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.hash_table;
// 해시 테이블 배열로 직접 구현
class MyHashTable{
    Integer[] table;
    int elemCnt; // 해시테이블 안에 데이터 몇개 들어가는지 확인 위한 변수

    // 상속 받기 위한 기본생성자
    MyHashTable(){}

    MyHashTable(int size){
        this.table = new Integer[size];
        this.elemCnt = 0;
    }

    public int getHash(int key){
        return key % this.table.length;
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key); // 해시값
        this.table[idx] = data; // 일치하는 인덱스에 해시값 넣기
        this.elemCnt++;
    }

    public int getValue(int key){
        int idx = this.getHash(key);
        return this.table[idx];
    }

    public void removeValue(int key){
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elemCnt--;
    }

    public void printHashTable(){
        System.out.println("Hash Table========");
        for(int i=0; i<this.table.length; i++){
            System.out.println(i + ":" + this.table[i]);
        }
    }

}
public class Practice1 {
    public static void main(String[] args) {
//        Test code
        MyHashTable ht = new MyHashTable(7);
        ht.setValue(1, 1);
        ht.setValue(2, 2);
        ht.setValue(3, 3);
        ht.setValue(4, 4);
        ht.setValue(5, 5);
        ht.printHashTable();
        ht.setValue(8, 6); // 해시충돌
        ht.printHashTable();


    }
}
