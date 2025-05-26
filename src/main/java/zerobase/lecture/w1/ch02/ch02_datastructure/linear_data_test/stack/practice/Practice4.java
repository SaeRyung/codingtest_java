package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data_test.stack.practice;
// 두 문자열 비교
// 단, #은 backspace 로 바로 이전의 문자를 삭제하는 기능이라고 가정

// 입력: s1 = "tree", s2 = "th#ree"
// 출력: true
// 입력: s1 = "ab#a" , s2 = "aab#"
// 출력: true
// 입력: s1 = "wo#w", s2 = "ww#o"
// 출력: false

import java.util.Stack;

public class Practice4 {
    public static boolean stringCompare(String s1, String s2) {

        String s1After = doBackspace(s1);
        String s2After = doBackspace(s2);
        return s1After.equals(s2After);
    }

    // stack 별도 공간 만드는 메서드
    public static String doBackspace(String s){
//        stack 선언
        Stack stack = new Stack();
//            반복문을 사용해서 문자열 하나씩 비교하기
        for(char c : s.toCharArray()){
//               문자열이 "#"이며 stack 이 비어있지 않다면 pop 으로 삭제하기

/*      char는 객체가 아니라 기본 타입이므로 equals() 메서드가 없음
        기본 타입 vs 객체:
        기본 타입 (char, int, double 등): == 사용
        객체 (String, Integer 등): equals() 사용
따라서 char 비교할 때는 ==를 사용하는 것이 가장 간단하고 효율적입니다!
* */
            if(c == '#' && !stack.isEmpty()){
                stack.pop();
            } else {
//                    문자열이라면 push
                stack.push(c);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
//        Test code
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2)); //true

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2)); //true

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2)); //false
    }
}
