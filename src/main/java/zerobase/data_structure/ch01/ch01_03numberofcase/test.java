package zerobase.data_structure.ch01.ch01_03numberofcase;

public class test {
    public static void main(String[] args) {
        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

//        합의 법칙
//        두 개의 주사위를 던졌을 때 합이 3 또는 4의 배수인 경우의 수

        int cntA = 0;
        int cntB = 0;
        int AandB = 0;

        for(int itemA : dice1){
            for(int itemB : dice2){
                if((itemA + itemB) % 3 == 0){
                    cntA++;
                }
                if((itemA + itemB) % 4 == 0){
                    cntB++;
                }
                if((itemA + itemB) % 12 == 0){
                    AandB++;
                }
            }
        }

        System.out.println(cntA + cntB - AandB);
//        곱의 법칙
//        두 개의 주사위를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수
        int numA = 0;
        int numB = 0;

        for(int itemA : dice1) {
            if ((itemA % 3) == 0) {
                numA++;
            }
        }
        for(int itemB : dice2){
                if((itemB % 4) == 0){
                    numB++;
            }
        }
        System.out.println("3의 배수와 4의배수인 경우: " + numA * numB);
    }
}
