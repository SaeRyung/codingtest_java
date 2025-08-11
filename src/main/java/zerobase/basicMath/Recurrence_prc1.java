package zerobase.basicMath;
// practice1
// 팩토리얼을 재귀함수로 구현하시오
public class Recurrence_prc1 {

    static int factorial(int n) {
        if(n == 1){
            return 1;
        } else {
            return n + factorial(n-1);
        }
    }

    public static void main(String[] args) {
//        TestCode
        System.out.println(factorial(5));
        System.out.println(factorial(10));
    }
}
