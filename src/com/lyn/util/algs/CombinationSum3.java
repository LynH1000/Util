package com.lyn.util.algs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();

        combinationSum3.solution(4, 1);
    }

    public List<List<Integer>> solution(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += i;
        }
        if (sum > n) {
            return result;
        }


        System.out.println(result.toString());
        return result;
    }
}
