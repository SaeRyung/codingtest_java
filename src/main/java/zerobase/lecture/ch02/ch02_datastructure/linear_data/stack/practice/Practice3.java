package zerobase.lecture.ch02.ch02_datastructure.linear_data.stack.practice;
// 후위표기법 연산
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0
import java.util.Stack;

public class Practice3 {
    public static double calculate(String str){
        Stack<Double> stack = new Stack();
//        반복문으로 문자열을 하나씩 끊어서 가져오기, 공백 기준으로 끊기
        for(String i : str.split(" ")){
//            "+" 인 경우 두 값을 더하기
            if(i.equals("+")){
                stack.push(stack.pop() + stack.pop());
//                "-" 인 경우, 앞쪽에 마이너스가 붙어야 한다.
            } else if (i.equals("-")) {
                stack.push(- stack.pop() + stack.pop());
//                "*" 인 경우 두 값을 곱하기
            } else if(i.equals("*")){
                stack.push(stack.pop() * stack.pop());
//                "/" 인 경우 앞의 갚을 먼저 1로 나눠서 계산하기
            } else if (i.equals("/")) {
                stack.push(1/stack.pop() * stack.pop());
            } else{
//                일반 숫자들이 들어온 경우, stack에 넣기
                stack.push(Double.parseDouble(i));
            }
        }
//        최종 결과 pop으로 return
        return stack.pop();
    }

    public static void main(String[] args) {
//        Test code
        System.out.println(calculate("2 2 +"));         // 4
        System.out.println(calculate("2 2 -"));         // 0
        System.out.println(calculate("2 2 *"));         // 4
        System.out.println(calculate("2 2 /"));         // 1

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));         // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));             // 14
    }
}
