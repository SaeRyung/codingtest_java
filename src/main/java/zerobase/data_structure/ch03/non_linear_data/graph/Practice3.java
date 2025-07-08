package zerobase.data_structure.ch03.non_linear_data.graph;
// 인접리스트 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphList2 extends MyGraphList{
    public MyGraphList2(int size){
        super(size);
    }
    public void dfs(int id){
        boolean[] visited = new boolean[this.elemCnt]; // 들어있는 노드 수 만큼 만들어주기
        Stack<Integer> stack = new Stack<>();

        stack.push(id); // 넣어주기
        visited[id] = true; // 방문 배열 체크

        while (!stack.isEmpty()){
            int curId = stack.pop(); // 처음에 스택에서 하나 꺼내기
            System.out.print(this.vertices[curId] + " ");

//            인접 정점 찾기 -- 여기서 행렬과 차이
            Node cur = this.adjList[curId];
            while (cur != null){
                if (visited[cur.id] == false){
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public void bfs(int id){
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(id);
        visited[id] = true;

        while (!queue.isEmpty()){
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            Node cur = this.adjList[curId];
            while (cur != null){
                if (visited[cur.id] == false){
                    queue.add(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }
}

public class Practice3 {
    public static void main(String[] args) {
//        Test code
        MyGraphList2 graph = new MyGraphList2(7);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.printAdjacentList();

        System.out.println();
        graph.dfs(0); // A B E G F C D
        graph.bfs(0); // A D C B F E G
    }
}
