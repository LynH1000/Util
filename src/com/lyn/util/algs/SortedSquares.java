package com.lyn.util.algs;

import java.util.Arrays;

/*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
* 输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
*
* */
public class SortedSquares {
    public int[] solution(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];

        }
        Arrays.sort(result);
        return result;
    }


}
