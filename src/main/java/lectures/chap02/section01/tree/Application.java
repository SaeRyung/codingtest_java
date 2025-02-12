package lectures.chap02.section01.tree;

import java.util.TreeMap;
import java.util.TreeSet;

/* Java Collection Framework에는 TreeSet과 TreeMap이 있다.
 * 내부적으로 레드-블랙 트리로 관리 되고 있다. */
public class Application {
    public static void main(String[] args) {
        // TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 요소 추가
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);

        // 최소값 및 최대값 조회
        System.out.println("TreeSet 최소값: " + treeSet.first());
        System.out.println("TreeSet 최대값: " + treeSet.last());

        // 요소 제거
        treeSet.remove(2);
        System.out.println("TreeSet 요소 제거 후: " + treeSet);

        // TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // 요소 추가
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        // 특정 키에 대한 값 조회
        System.out.println("TreeMap에서 키 2의 값: " + treeMap.get(2));

        // 최소 키 및 최대 키 조회
        System.out.println("TreeMap 최소 키: " + treeMap.firstKey());
        System.out.println("TreeMap 최대 키: " + treeMap.lastKey());

        // 특정 키-값 쌍 제거
        treeMap.remove(2);
        System.out.println("TreeMap 요소 제거 후: " + treeMap);
    }
}
