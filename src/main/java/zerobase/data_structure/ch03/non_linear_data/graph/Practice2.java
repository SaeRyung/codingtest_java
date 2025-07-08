package zerobase.data_structure.ch03.non_linear_data.graph;
// 인접행렬 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphMatrix2 extends MyGraphMatrix {
    public MyGraphMatrix2(int size){
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

//            인접 정점(행렬)확인, 역순으로 찾기
            for(int i=this.elemCnt-1; i>=0; i--){
                if(this.adjMat[curId][i] == 1 && visited[i] == false){
                    stack.push(i);
                    visited[i] = true;
                }
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

            for(int i=this.elemCnt-1; i>=0; i--){
                if(this.adjMat[curId][i] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class Practice2 {
    public static void main(String[] args) {
//        Test code
        MyGraphMatrix2 graph = new MyGraphMatrix2(7);
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
        graph.printAdjacentMatrix();

        System.out.println();
        graph.dfs(0); // A B E G F C D
        graph.bfs(0); // A D C B F E G
    }
}
/*
  A B C D E F G
A 0 1 1 1 0 0 0
B 1 0 0 0 1 0 0
C 1 0 0 0 0 1 0
D 1 0 0 0 1 1 0
E 0 1 0 1 0 0 1
F 0 0 1 1 0 0 1
G 0 0 0 0 1 1 0
*/