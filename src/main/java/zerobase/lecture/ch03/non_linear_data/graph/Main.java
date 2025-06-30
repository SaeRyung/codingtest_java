package zerobase.lecture.ch03.non_linear_data.graph;
/* 그래프(Graph)
# 정점과 간선으로 이루어진 자료구조(Cyclic)
- 연결된 정점간의 관계를 표현할 수 있는 자료구조
# 그래프의 용도
- 지하철 노선도, 통신 네트워크,,
* */

// 비선형 자료구조 - 그래프
// 인접 행렬을 이용한 그래프 구현

class MyGraphMatrix {
    char[] vertices; // 각각 알파벳 담을 변수
    int[][] adjMat; // 2차원 인접 행렬
    int elemCnt; // 그래프 정점 갯수 세는 변수

    public MyGraphMatrix() {
    }

    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    //    현재 가득 채워졌는지 확인하는 메서드
    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    //    vertices 추가하는 메서드
    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is full");
            return;
        }
        this.vertices[this.elemCnt++] = data;
    }

    //    무방향 그래프
    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }

    //    방향 그래프면 한쪽 업데이트
    public void addDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 1;
    }

    //    무방향 그래프 삭제
    public void deleteEdge(int x, int y) {
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    }

    //    방향 그래프 삭제
    public void deleteDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 0;
    }
//    인접 행렬 출력
    public void printAdjacentMatrix(){
        System.out.print("  ");
        for(char item : this.vertices){
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " ");
            for(int j = 0; j < this.elemCnt; j++){
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class Main {
    public static void main(String[] args) {
//        Test code
        MyGraphMatrix graph = new MyGraphMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentMatrix();

/*
  A B C D
A 0 1 1 0
B 1 0 1 1
C 1 1 0 1
D 0 1 1 0
 */

    }
}
