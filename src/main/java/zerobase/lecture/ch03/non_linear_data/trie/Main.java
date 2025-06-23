package zerobase.lecture.ch03.non_linear_data.trie;
/* 비선형 자료구조 - 트라이(trie)
- 문자열을 저장하고 빠르게 탐색하기 위한 트리 형태의 자료구조
- 정렬된 트리 구조
- 문자열 저장을 위한 메모리가 필요하지만 탐색이 빠름, 길이가 N인 문자열 탐색의 시간 복잡도: O(N)
(구축 시 생성 복잡도: O(MN), M: 문자열 개수)

# 구현
- key, value 로 이루어진 노드로 구성
- key: 알파벳, value : 자식노드
* */

import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
        // 단어의 끝 표시
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    //    문자열 삽입
    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 현재 해당 문자로 시작하는 node가 cur 기준으로 있으면 넣어주기, 없으면 넘어가기
            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c); // 해당 child로 넘기기

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }
    /*
    * [ROOT]
        └─ 'a' (isTerminal: false)
            └─ 'p' (isTerminal: false)
                └─ 'p' (isTerminal: false)
                    └─ 'l' (isTerminal: false)
                        └─ 'e' (isTerminal: true) ← "apple"


         [ROOT]
            └─ 'a' (isTerminal: false)
                └─ 'p' (isTerminal: false)
                    ├─ 'p' → 'l' → 'e' (apple, isTerminal: true)
                    └─ 'r' → 'i' → 'l' (april, isTerminal: true) ← 새로 추가!
    * */

    //    탐색하기
    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 현재 문자로 시작하는 키가 있는지 확인
            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }
            // i 번째 인덱스가 끝까지 도달한 경우
            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }

    //    문자열 삭제
    public void delete(String str) {
        boolean ret = this.delete(this.root, str, 0);
        if (ret) {
            System.out.println(str + " 삭제 완료");
        } else {
            System.out.println(str + " 단어가 없습니다.");
        }
    }

    //    해당 문자를 비교하면서 재귀호출
    public boolean delete(Node node, String str, int idx) {
        char c = str.charAt(idx);

//        현재 노드 child 에 키가 없으면 false
        if(!node.child.containsKey(c)) {
            return false;
        }
        Node cur = node.child.get(c);
        idx++;

        if (idx == str.length()) {
            if (!cur.isTerminal) {
                return false;
            }
            cur.isTerminal = false;

            if(cur.child.isEmpty()) {
                node.child.remove(c);
            }
        } else {
            if(!this.delete(cur, str, idx)){
                return false;
            }
            if(!cur.isTerminal && cur.child.isEmpty()) {
                node.child.remove(c);
            }
        }

        return true;
    }


}

public class Main {
    public static void main(String[] args) {
//        Test code
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
//        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple")); //true
        System.out.println(trie.search("april")); //true
        System.out.println(trie.search("app"));   //false > app 을 따로 넣지는 않았을 때 false
        System.out.println(trie.search("ace"));   //true
        System.out.println(trie.search("bear"));  //true
        System.out.println(trie.search("best"));  //true
        System.out.println(trie.search("abc"));   //false

        System.out.println();
        trie.delete("apple"); // apple 삭제 완료
        System.out.println(trie.search("apple")); // false
        System.out.println(trie.search("april")); // true
        System.out.println(trie.search("appl")); // false
        trie.delete("apple"); // apple 단어가 없습니다.

    }
}
