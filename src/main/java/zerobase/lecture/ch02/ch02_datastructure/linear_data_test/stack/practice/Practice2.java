package zerobase.lecture.ch02.ch02_datastructure.linear_data_test.stack.practice;
// 괄호 짝 검사
// 입력: "("
// 출력: Fail

// 입력: "()"
// 출력: Pass

/* 괄호 순서 상관없이 짝 검사하는 경우
public static void checkParenthesis(String str){
    int count = 0; // 괄호 개수를 세는 변수

    // 반복문을 통해 문자열 하나씩 가져오기
    for(String s : str.split("")){
        if(s.equals("(")){
            count++; // 여는 괄호면 +1
        }
        else if(s.equals(")")){
            count--; // 닫는 괄호면 -1
        }
    }

    // count가 0이면 괄호 개수가 맞음
    if(count == 0){
        System.out.println("PASS");
    } else {
        System.out.println("FAIL");
    }
}
* */

import java.util.Stack;

public class Practice2 {
    public static void checkParenthesis(String str){
        Stack<String> stack = new Stack<>();
//        괄호 짝 맞는지 체크하는 변수
        boolean checkFlag = true;

//        반복문을 통해 문자열 하나씩 가져오기
        for(String s : str.split("")){
//            가져온 문자열이 닫는 모양이라면 stack 에 넣기
            if(s.equals("(")){
                stack.push("(");
            }
//                가져온 문자열이 열린 모양
            else if(s.equals(")")){
//                stack 가 비었을 경우, checkFlag 는 false 후 반복문 종료
                if(stack.isEmpty()){
                    checkFlag = false;
                    break;
                }
//                    비어있지 않다면 stack 에서 삭제
                stack.pop();
            }
        }
//        checkFlag 가 true 고 stack 가 비었다면 PASS, 아니면 FAIL 출력
        if(checkFlag && stack.isEmpty()){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
    }

    }

    public static void main(String[] args) {
//        Test code
        checkParenthesis("("); //FAIL
        checkParenthesis(")"); //FAIL
        checkParenthesis("()"); //PASS
        checkParenthesis("()()()"); //PASS
        checkParenthesis("(())()"); //PASS
        checkParenthesis("(((()))"); //FAIL

    }
}
