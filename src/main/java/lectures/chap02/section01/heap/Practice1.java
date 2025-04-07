package lectures.chap02.section01.heap;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.PriorityQueue;

public class Practice1 {
// 절댓값 합 - 백준 11286
    public String solution(Integer[] input) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            // 첫번째 두번째를 절대값으로 만든 후 비교
            int absCompare = Integer.compare(Math.abs(o1), Math.abs(o2));

            // 0 인 경우 값으로만 비교
            if(absCompare == 0){
                return Integer.compare(o1, o2);
            }

            return absCompare;
        });

        StringBuilder sb = new StringBuilder();

        // 배열을 가져와 판단
        for(int x : input) {
            // 0이면 데이터 꺼내기
            if(x == 0){
                if(pq.isEmpty()){
                    // 비어있다면 0 넣기
                    sb.append("0 ");
                }else{
                    sb.append(pq.poll()).append(" ");
                }
            }else{
                // 0 이 아닐 시 데이터 담기
                pq.offer(x);
            }
        }

        return sb.toString().trim();
    }
}
