package lectures.chap02.section01.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Java Collection Framework에는 ArrayList, LinkedList 등이 구현 되어 있다. */
/*
배열 기반 : 메모리 효율성이 높고 캐시 지역성이 좋지만(조회 성능), 고정된 크기와 동적 크기 조정의 복잡성이 있다.
연결 리스트 기반 : 동적 크기 조정이 가능하며 변경이 용이하다. 또한 메모리 오버헤드(포인터)가 있지만 메모리 사용이 효율적이다.
 */
public class Application {
    public static void main(String[] args) {
        /* ArrayList */
        List<Integer> list = new ArrayList<>();

        // 요소 추가
        list.add(1);
        list.add(2);
        list.add(3);

        // 요소 조회
        System.out.println(list.get(1));

        // 요소 제거
        list.remove(2);
        System.out.println(list);

        // 리스트 크기
        System.out.println(list.size());

        /* LinkedList */

        List<Integer> list2 = new LinkedList<>();

        // 요소 추가
        list2.add(1);
        list2.add(2);
        list2.add(3);

        // 요소 조회
        System.out.println(list2.get(1));

        // 요소 제거
        list2.remove(2);
        System.out.println(list2);

        // 리스트 크기
        System.out.println(list2.size());
    }
}

