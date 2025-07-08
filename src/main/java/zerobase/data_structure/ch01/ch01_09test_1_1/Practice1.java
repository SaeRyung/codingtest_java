package zerobase.data_structure.ch01.ch01_09test_1_1;

import java.util.ArrayList;

// 삼각형의 행의 수가 입력으로 주어졌을 때, 파스칼의 삼각형을 출력하세요
public class Practice1 {

    // 반환을 해줄 ArrayList
    public static ArrayList<ArrayList<Integer>> solution(int numRows){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for(int j=0; j<i+1; j++){
                if(j == 0 || j == i){
                    list.add(1);
                } else {
                    int x = result.get(i-1).get(j-1);
                    int y = result.get(i-1).get(j);
                    list.add(x+y);
                }
            }
            result.add(list);
        }
        return  result;
    }

    public static void main(String[] args) {
//        Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
