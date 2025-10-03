package leetcode.w1;

import java.util.Stack;

/* Valid Parentheses - 유효한 괄호
 * (, ), {, }, [, ] 문자만으로 이루어진 문자열 s 가 주어졌을 때
 * 이 문자열이 유효한지 판단하세요
 *
 * 유효한 문자열 조건
 * - 여는 괄호는 같은 종류의 닫는 괄호로 닫혀야 함
 * - 여는 괄호는 올바른 순서로 닫혀야 함
 * - 모든 닫는 괄호는 같은 종류의 여는 괄호와 대응되어야 함
 *
 * 입력1
 * ()
 * 결과: true
 *
 * 입력2
 * (){}[]
 * 결과: true
 *
 * 입력3
 * (]
 * 결과: false
 *
 * 입력4
 * ([)]
 * 결과: false*/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        /* 스택의 특성 LIFO(Last In First Out, 후입선출
        * 가장 최근에 열린 괄호가 가장 먼저 닫혀야 함, 스택의 동작 방식
        *
        * 1. 여는 괄호 (, {, [ -> 스택에 push
        * 2. 닫는 괄호 ), }, ] -> 스택에서 pop 후 짝 확인
        * 3. 최종 확인 -> 스택이 비어 있어야 유효 */

        /* 시간복잡도: O(n) - 문자열 한 번만 순회
        * 공간복잡도: O(n) - 최악의 경우 모든 괄호가 스택에 저장 Ex. ((((*/

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
