package zerobase.data_structure.ch01.ch01_05combination;

public class test {
    public static void main(String[] args) {
//        1. 조합
//        서로 다른 4명 중 주번 2명 뽑는 경우의 수(순서X)
        int all = 4;
        int pick = 2;
        int P_result = 1;
        int C_result = 1;

        for(int i=all; i>=(all-pick+1); i--){
            P_result *= i;
        }
        for(int i=1; i<=pick; i++){
            C_result *= i;
        }
        System.out.println("조합-서로 다른 4명 중 주번 2명 뽑는 경우의 수: " + P_result/C_result);

//        2. 중복 조합
//        후보 2명, 유권자 3명일 때 무기명 투표 경우의 수
        all = 2;
        pick = 3;
        int result1 = 1;
        int result2 = 1;
    }
}
