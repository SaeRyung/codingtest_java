package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.stack.practice;
// 괄호 짝 검사
// 입력: "("
// 출력: Fail

// 입력: "()"
// 출력: Pass

import java.util.Stack;

public class Practice2 {
    public static void checkParenthesis(String str){
        Stack stack = new Stack();

        int len = str.length();

        if(len == 1){
            System.out.println("Fail");
        } else {
            for(String i : str.split("")){
                if(i.equals("(")){
                    stack.push(i);
                }
                if(i.equals(")")){
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        }
    }

    public static void main(String[] args) {
//        Test code
        checkParenthesis("(");
        checkParenthesis(")");
        checkParenthesis("()");
        checkParenthesis("()()()");
        checkParenthesis("(())()");
        checkParenthesis("(((()))");

    }
}
