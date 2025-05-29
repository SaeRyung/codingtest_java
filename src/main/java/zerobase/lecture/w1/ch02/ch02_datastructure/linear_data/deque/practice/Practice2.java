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
        // 데크 자료형 선언
        Deque<String> deque = new ArrayDeque();
//        isFront, isPalindrome 변수 만들기
        boolean isFront = true;
        boolean isPalindrome = true;

//        str 들어오는 형태를 한글자씩 잘라서 deque 에 넣기
        for(String s : str.split("")){
//            데크의 첫번째 방향으로 넣기
            deque.addFirst(s);
        }
//        데크 반복문을 돌려 비어있는지 확인
        while (!deque.isEmpty()){
//            앞글자와 뒷글자를 하나씩 가져와서 같은지, 다른지 비교하기
//            remove를 쓰는 경우, 데이터가 없을때 에러 발생합니다. poll을 써서 null 반환으로
            String s1 = (String)deque.pollFirst();
            String s2 = (String) deque.pollLast();

//            펠린드롬 false 조건인 경우 false 반환 후 반복문 종료
            if(s1 != null && s2 != null && !s1.equals(s2)){
               isPalindrome = false;
               break;
            }
        }
        return isPalindrome;
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
