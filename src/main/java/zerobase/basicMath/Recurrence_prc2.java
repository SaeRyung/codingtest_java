package zerobase.basicMath;
// Practuce2
// 최대공약수를 재귀함수로 구현
public class Recurrence_prc2 {

    static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
//        TestCode
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
    }
}
