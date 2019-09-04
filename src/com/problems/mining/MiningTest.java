package com.problems.mining;


public class MiningTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {
                {1,-1,-1,1},
                {4,-1,7,-1},
                {-1,5,6, 5},
                {-1,9,-1,4}
        };

        Integer res = solution.findMaxPath(graph);
        System.out.println(String.format("The max gain for mining path is: %d", res));
    }
}
