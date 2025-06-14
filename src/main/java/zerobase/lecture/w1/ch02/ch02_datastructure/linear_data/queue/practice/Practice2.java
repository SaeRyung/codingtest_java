package zerobase.lecture.w1.ch02.ch02_datastructure.linear_data.queue.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/* 요세푸스 문제
N과 K가 주어졌을 때 (N, K) 요세푸스 순열을 구하시오
N과 K는 N >= K 를 만족하는 양의 정수이다.
1부터 N번까지 N명이 순서대로 원을 이루어 모여 있다.
이 모임에서 원을 따라 순서대로 K번째 사람을 제외한다.
모든 사람이 제외될 때까지 반복하며 이 때, 제외되는 순서가 요세푸스 순열이다.

입력: N = 5, K = 2
결과: 2, 4, 1, 5, 3

입력: N = 7, K = 3
결과: 3, 6, 2, 7, 5, 1, 4
*/
public class Practice2 {
    public static ArrayList getJosephusPermutation(int N, int K) {
        Queue queue = new LinkedList();
        ArrayList result = new ArrayList();

        IntStream.range(1, N+1).forEach(x -> queue.add(x));

//        k 번째 사람인지 체크하기 위한 변수 cnt
        int cnt = 0;
        while(!queue.isEmpty()){
//            맨 처음 데이터 삭제
            int data = (int)queue.remove();
//            카운트 증가
            cnt += 1;
//            cnt를 k로 나눠서 몇 번째 사람인지 체크하기
            if(cnt % K == 0){
//                순번 사람이라면 결과값에 순서대로 올 수 있도록 더하기
                result.add(data);
            } else{
//                아니라면 queue 뒤에 다시 추가
                queue.add(data);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Test code
        System.out.println(getJosephusPermutation(5, 2));
        System.out.println(getJosephusPermutation(7, 3));
    }
}
