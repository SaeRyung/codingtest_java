package lectures.chap02.section01.que;

import java.util.LinkedList;
import java.util.Queue;

// 요세푸스 문제 - 백준 1158
public class Practice1 {

    public String solution(int n, int k){

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i <= n; i++){
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        /* 큐에서 모든 사람이 제거 될 때까지 반복 */
        while(!queue.isEmpty()){

            /* 앞에서 k-1 명을 뒤로 보내기 */
            for(int i=1; i <= k-1; i++){
                queue.offer(queue.poll());
            }

            /* 제거할 사람을 stringbuilder에 기록 */
            sb.append(queue.poll());

            /* 제거할 사람이 남은 경우, 기록 */
            if(!queue.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        return sb.toString();
    }
}
