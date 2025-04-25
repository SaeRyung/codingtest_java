package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.deque.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

/* Palindrome 찾기
Palindrome 면 true, 아니면 false 를 반환
Palindrome : 앞으로 읽어도 거꾸로 읽어도 같은 문자열

입력: a
결과: true

입력: madam
결과: true

입력: abab
결과: false
* */
public class Practice2 {
    public static boolean checkPalindrome(String str){
        Deque<String> deque = new ArrayDeque();

        for(String ch : str.split("")){
            deque.addLast(ch);
        }

        while (deque.size()>1){
            String first = deque.removeFirst();
            String last = deque.removeLast();

            if(!first.equals(last)){
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Test code
        System.out.println(checkPalindrome("a")); //true
        System.out.println(checkPalindrome("aba")); // true
        System.out.println(checkPalindrome("abba")); // true
        System.out.println(checkPalindrome("abac")); // false
        System.out.println(checkPalindrome("abcba")); // true
        System.out.println(checkPalindrome("abccba")); //true
        System.out.println(checkPalindrome("madam")); // true
    }
}
