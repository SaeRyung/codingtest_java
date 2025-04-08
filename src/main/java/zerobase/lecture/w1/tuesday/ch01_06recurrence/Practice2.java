package zerobase.lecture.w1.tuesday.ch01_06recurrence;

// 팩토리얼을 재귀함수로 구현하시오

public class Practice2 {

    static int factorial(int n){
        if ( n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
//        Test code
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));

    }
}
