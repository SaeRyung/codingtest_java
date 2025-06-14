package zerobase.lecture.w1.ch03.non_linear_data.priority_queue.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/* nums 배열에 주어진 정수들 중에서 k번째로 큰 수를 반환하는 프로그램을 작성하세요

입력 예시
입력: 3, 1, 2, 7, 6, 4
k : 2
출력: 6

입력: 1, 3, 7, 4, 2, 8, 9
k: 7
출력: 1
* */
public class Practice1 {
    public static int solution1(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 최대힙으로 바꾸면
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int num : nums){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static int solution2(int[] nums, int k){
        Arrays.sort(nums); // 정렬, 오름차순
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
//        Test code
        int[] nums = {3, 1, 2, 7, 6, 4};
        System.out.println(solution1(nums, 2)); // 6
        System.out.println(solution2(nums, 2)); // 6
        System.out.println();

        nums = new int[]{1, 3, 7, 4, 2, 8, 9};
        System.out.println(solution1(nums, 7)); // 1
        System.out.println(solution2(nums, 7)); // 1
    }
}
