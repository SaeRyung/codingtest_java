package zerobase.lecture.w1.monday.ch01_02set;

// ArrayList를 사용한 집합 구현 실습

import java.util.ArrayList;

class SelfSet{
//    ArrayList
    ArrayList<Integer> list;

//    생성자1
    SelfSet(){
        this.list = new ArrayList<Integer>();
    }

//    생성자2
    SelfSet(int[] arr){
        this.list = new ArrayList<Integer>();

        for(int item : arr){
            this.list.add(item);
        }
    }

//    원소 추가(중복 X)
    public void add(int x){
        for(int item : this.list){
            if(item == x){
                return;
//                 같은 게 있으면 return 해서 함수 벗어남
            }
        }
//        for문 도는 동안 같은 값이 없다면 데이터 추가
        this.list.add(x);
    }

//    교집합
    public SelfSet retainAll(SelfSet b) {
        SelfSet result = new SelfSet(); //반환 위한 자료형

        for(int itemA : this.list) {
            for(int itemB: b.list) {
                if(itemA == itemB){
                    // 공통된 원소만 들어가서 새 배열로 반환된다.
                    result.add(itemA);
                }
            }
        }
        return result;
    }
// 합집합
    public SelfSet addAll(SelfSet b){
        SelfSet result = new SelfSet();

        for(int itemA : this.list){
            result.add(itemA);
        }
        for(int itemB : b.list){
            result.add(itemB);
        }
        return result;
    }
//    차집합
    public SelfSet removeAll(SelfSet b) {
        SelfSet result = new SelfSet();

        for(int itemA : this.list){
            boolean containFlag = false; // 원소 존재 유무 위해

            for(int itemB : b.list){
                if(itemA == itemB){
                    containFlag = true;
                    // 원소 찾으면 순회하지 않아도 되기에 안쪽 반복문 break
                    break;
                }
            }
//            false => 같은 값이 없다는 뜻, 살아남는 원소 더한다.
            if(!containFlag){
                result.add(itemA);
            }
        }
        return result;
    }

}

public class MySet {
    public static void main(String[] args) {

//        Test code
        SelfSet a = new SelfSet();

//        1. 자바에서 집합 사용 - HashSet
//        System.out.println("=== HashSet ===");
//        HashSet set1 = new HashSet();
//        set1.add(1);
//        set1.add(1);
//        set1.add(1);
//        System.out.println("set1 = " + set1);
//        set1.add(2);
//        set1.add(3);
//        System.out.println("set1 = " + set1);
//        set1.remove(1);
//        System.out.println("set1 = " + set1);
//        System.out.println(set1.size());
//        System.out.println(set1.contains(2));

//        2. 집합 연산
//        System.out.println("== 집합 연산 ==");

//        2-1. 교집합
//        HashSet a = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
//        HashSet b = new HashSet(Arrays.asList(2, 4, 6, 8, 10));
//        a.retainAll(b);
//        System.out.println("교집합: " + a); //a의 내용이 바뀐다.

//        2-2. 합집합
//        a.addAll(b);
//        System.out.println("합집합: " + a);

//        2-3. 차집합
//        a.retainAll(b);
//        System.out.println("차집합 " + a);
    }
}
