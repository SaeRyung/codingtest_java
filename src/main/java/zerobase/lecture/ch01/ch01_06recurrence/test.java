package zerobase.lecture.ch01.ch01_06recurrence;

public class test {
    public static void main(String[] args) {
//        재귀함수
//        1, 3, 9, 27 ,,, 의 n번째 수
        int n = 4;
        int result = 1;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                result = 1;
            } else {
                result *= 3;
            }
        }
        System.out.println(String.format("1, 3, 9, 27,,,의 %d번째 수: %d", n, result));
//        점화식
//        피보나치 수열 1, 1, 2, 3, 5, 8, 13,,,의 n번째 수
        System.out.println("피보나치 수열");
        n = 7;
        result = 0;
        int a1 = 1;
        int a2 = 1;
        System.out.print(a1 + " " + a2 + " ");
        if (n < 3) {
            result = 1;
        } else {
            for (int i = 2; i < n; i++) {
                result = a1 + a2;
                System.out.print(result + " ");
                a1 = a2;
                a2 = result;
            }
        }
    }
}
