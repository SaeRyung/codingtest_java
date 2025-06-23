package zerobase.lecture.ch02.ch02_datastructure.linear_data.stack.practice;
// 문자열 뒤집기
// 입력: "Hello"
// 출력: "olleH"
// 입력: 1 3 5 7 9
// 출력: 9 7 5 3 1

import java.util.Stack;

public class Practice1 {
    public static String reverseString(String str){
        Stack<String> stack = new Stack<>();
        String result = "";

//        반복문을 통해 string로 받는다, "" 로 split 을 활용해 한글자씩 받아오기
        for(String i : str.split("")){
//            한글자씩 받아온 문자열 stack 에 넣기
            stack.push(i);
        }
//        반복문 탈출조건, 비어있는지 체킹하여 반복문 돌려주기
        while (!stack.isEmpty()){
//            비어있지 않다면 stack의 pop으로 한글자씩 가져오기
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
