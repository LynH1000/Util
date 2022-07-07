package com.lyn.util.algs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combine {

    public List<List<Integer>> solution(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();

        if (k <= 0 || n < k) {
            return result;
        }
        backtracking(n, k, 1, path, result);
        return result;
    }

    public void backtracking(int n, int k, int start, Stack<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1, path, result);
            path.pop();
        }

    }
}

    /*
    void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}
    * */

