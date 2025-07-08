package zerobase.data_structure.ch01.ch01_04permutation;

public class test {
    public static void main(String[] args) {
//        팩토리얼
//        5!
        int result1 = 1;
        for(int i=1; i<=5; i++){

            result1 *= i;
        }
        System.out.println("팩토리얼 5 : " + result1);
//        순열
//        5명을 3줄로 세우는 경우의 수
        int all = 5;
        int line = 3;
        int result2 = 1;
        for(int i=all; i>=(all-line+1); i--){
            result2 *= i;
        }
        System.out.println("순열 - 5명을 3줄로 세우는 경우의 수 : " + result2);
//        중복순열
//        서로 다른 4개의 수 중 2개를 뽑는 경우의 수(중복 허용)
//        (선택할 수 있는 것의 갯수)^(선택하는 횟수)
        all = 4;
        int pick = 2;
        int result3 = 1;

        for(int i=0; i<pick; i++) {
            result3 *= all;
        }

        System.out.println("중복순열 - 서로 다른4개 수 중 2개 뽑는 경우의수: " + result3);
//        원순열
//        원 모양의 테이블에 3명을 앉히는 경우의 수
        all = 3;
        int result4 = 1;
        for(int i=1; i<=all-1; i++){
            result4 *= i;
        }
        System.out.println("원순열 - 원 모양의 테이블에 3명을 앉히는 수: " +result4);
    }
}
