package com.lyn.util.algs;

public class MaxSubArray {
    public static void main(String[] args) {
        int[]input= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(input));
    }

    public static int solution(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
