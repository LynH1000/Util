package com.lyn.util.algs;

import java.util.ArrayList;
import java.util.List;

/*给定一个不含重复数字的数组 nums ，返回其所有可能的全排列 。你可以按任意顺序 返回答案。
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        boolean isUsed[] = new boolean[len];
        backtracking(result, route, isUsed, len, nums);
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> route, boolean[] isUsed, int len, int[] nums) {

        if (route.size() == len) {
            result.add(new ArrayList<>(route));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!isUsed[i]) {
                route.add(nums[i]);
                isUsed[i] = true;
                backtracking(result, route, isUsed, len, nums);
                isUsed[i] = false;
                route.remove(route.size() - 1);
            }
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