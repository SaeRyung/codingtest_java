package lectures.chap02.section01.stack;

import java.util.Stack;

public class Practice1 {

    public String solution(String input) {

        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()) {
            if(c == '(') {
                // 여는 괄호인 경우 stack에 넣는다.
                stack.push(c);
            } else {
                // 꺼낼 수 없다면 여는 괄호가 부족해서 짝이 안 맞는 상황
                if(stack.isEmpty()) return "NO";
                // 닫는 괄호인 경우 stack에서 pop 한다.
                stack.pop();
            }
        }
        // 모든 문자에 대해서 처리했는데 스택에 여는 괄호가 남아있다는 것은 닫는 괄호가 부족해서 짝이 안 맞음
        if(!stack.isEmpty()) return "NO";

        return "YES";
    }
}
