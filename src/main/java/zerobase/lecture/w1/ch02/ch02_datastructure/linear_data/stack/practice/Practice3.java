package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.stack.practice;
// 후위표기법 연산
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0
import java.util.Stack;

public class Practice3 {
    public static double calculate(String str){
        Stack<Double> stack = new Stack();

        for(String i : str.split(" ")){
            if(i.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if (i.equals("-")) {
                stack.push(- stack.pop() + stack.pop());
            } else if(i.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if (i.equals("/")) {
                stack.push(1/stack.pop() * stack.pop());
            } else{
                stack.push(Double.parseDouble(i));
            }
        }
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
