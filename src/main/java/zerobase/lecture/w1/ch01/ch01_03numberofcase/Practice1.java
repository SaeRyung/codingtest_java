package zerobase.lecture.w1.ch01.ch01_03numberofcase;

// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10 의 수 중 A 의 약수 또는 B 의 약수인 경우의 수
// 활용) 1~10 의 수 중 A 의 약수이면서 B 의 약수인 경우의 수

import java.util.ArrayList;

public class Practice1 {
//    약수
    public ArrayList getDivisor(int num){
        ArrayList result = new ArrayList();

        for(int i=1; i <= (int)num/2; i++){
            if(num % i == 0){
                result.add(i);
            }
        }
        result.add(num); //자기 자신 약수에 포함
        return result;
    }

//    최대공약수
//    GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB){
//        최대공약수는 항상 양수이므로, 공약수를 찾지 못했음을 명확히 표시하기 위함
        int gcd = -1;

        // 각 숫자들의 약수 먼저 구하기
        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB= this.getDivisor(numB);

        for(int itemA: (ArrayList<Integer>)divisorA){
            for(int itemB: (ArrayList<Integer>)divisorB){
                if(itemA == itemB){
                    if(itemA > gcd){
                        gcd = itemA;
                    }
                }
            }
        }
        return gcd;
    }

//    최소공배수
//    LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB){
        int lcm = -1;

        // 1. 먼저 최대공약수를 구한다.
        int gcd = this.getGCD(numA, numB);
        // 예외상황, 5인경우
        if (gcd != -1){
            lcm = numA * numB / gcd;
        }
        return lcm;
    }

    public static void main(String[] args) {
//        Test code
        int number1 = 10;
        int number2 = 6;

        Practice1 test = new Practice1();
        ArrayList l1 = test.getDivisor(number1);
        ArrayList l2 = test.getDivisor(number2);

        System.out.println("약수 l1 = " + l1);
        System.out.println("약수 l2 = " + l2);

        System.out.println("최대공약수 = " + test.getGCD(number1, number2));
        System.out.println("최소공배수 = " + test.getLCM(number1, number2));

    }
}