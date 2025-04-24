package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.stack.practice;
// 문자열 뒤집기
// 입력: "Hello"
// 출력: "olleH"
// 입력: 1 3 5 7 9
// 출력: 9 7 5 3 1

import java.util.Stack;

public class Practice1 {
    public static String reverseString(String str){
        Stack stack = new Stack();
        String result = "";

        for(String i : str.split("")){
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
//        Test code
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);
    }
}
