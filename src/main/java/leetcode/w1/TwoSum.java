package leetcode.w1;

import java.util.*;

/* Two Sum
정수 배열 nums 와 정수 target 이 주어졌을 때,
두 수를 더해서 target 이 되는 두 수의 인덱스를 반환하세요
- 각 입력에는 정확히 하나의 해답만 존재한다고 가정
- 같은 원소를 두 번 사용할 수 없음
- 답은 어떤 순서로 반환해도 괜찮음

입력 1
nums = [2, 7, 11, 15]
target = 9
결과: [0 ,1]

입력 2
nums = [3, 2, 4]
target = 6
결과: [1, 2]

입력 3
nums= [3, 3]
target = 6
결과: [0, 1]
*/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
/* HashMap 사용
시간복잡도: O(n) - 배열 한 번만 순회
공간복잡도: O(n) - 해시맵에 최대 n개 저장
=> 현재 숫자의 짝꿍을 이미 본 적 있는지 확인
* */
        HashMap<Integer, Integer> map = new HashMap<>();
//        1. HashMap 생성: <숫자, 인덱스> 형태로 저장
        /* HashMap - 객체만 저장할 수 있다
        * int는 기본타입이므로 Integer 사용
        * 코딩테스트에서는 그냥 Integer 사용 !!*/

        for(int i=0; i<nums.length; i++){
//            2. 배열 순회
            int findNum = target - nums[i];
//            3. 찾아야 할 짝궁 계산

//            map.containsKey
//            map.containsValue
            if(map.containsKey(findNum)){
//                4. 짝꿍이 해시맵에 있는지 확인
                return new int[] {
                        map.get(findNum), i
//                        있다면 [짝꿍의 인덱스, 현재 인덱스] 반환 후 종료
                        /* 값 가져오기
                        * int value = map.get(5, 10)
                        * Integer를 int로 자동 변환(Auto-unboxing)
                        * 객체 -> 기본타입*/
                };
            }
            map.put(nums[i], i);
//            5. 없다면 현재 숫자를 해시맵에 저장 - [숫자, 현재 인덱스]
            /* 값 추가 map.put(5, 10)
             * int를 넣어도 자동으로 Integer로 변환(Auto-boxing)
             * 기본타입 -> 객체 */
        }
        return new int[] {};
//        6. 해답이 없다면 빈 배열 반환
    }
}
