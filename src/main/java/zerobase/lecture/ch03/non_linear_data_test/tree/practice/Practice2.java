package zerobase.lecture.ch03.non_linear_data_test.tree.practice;
/* 각각의 엣지에 가중치가 있는 포화 이진 트리가 있다.
루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
이 때, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요

h = 트리 높이
w = 트리에서 각각 엣지의 가중치
res = 결과값
* */

class BinaryTree {
    int h; // 높이
    int[] arr; // 배열
    int res; // 결과값

    public BinaryTree(int h, int[] w) {
        this.h = h;
        arr = new int[(int) Math.pow(2, h + 1)]; // 포화이진트리 기준 하나 사용 X
        res = 0;

//        배열 인덱스 2부터 시작하는 엣지들을 w 배열의 0번 인덱스부터 차례로 매핑
        for (int i = 2; i < (int) Math.pow(2, h + 1); i++) {
            arr[i] = w[i - 2];
        }
    }

    public int dfs(int idx, int h) {
        // 높이가 같아진다면
        if (this.h == h) {
            // 결과값에 더하기
            res += arr[idx];
            // 총 값 return
            return arr[idx];
        }
        int left = dfs(idx * 2, h + 1);
        int right = dfs(idx * 2 + 1, h + 1);
        res += arr[idx] + Math.abs(left - right);
        return arr[idx] + Math.max(left, right);
    }
}

public class Practice2 {
    public static void solution(int h, int[] w) {
        BinaryTree bt = new BinaryTree(h, w);
        bt.dfs(1, 0);
        System.out.println(bt.res);
    }

    public static void main(String[] args) {
//        Test code
        int h = 2; // 트리의 높이
        int[] w = {2, 2, 2, 1, 1, 3}; // 15 트리에서 각각 엣지의 가중치
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1}; // 27
        solution(h, w);
    }
}
