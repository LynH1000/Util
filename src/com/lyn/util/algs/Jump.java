package com.lyn.util.algs;
/*给你一个非负整数数组nums ，你最初位于数组的第一个位置。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        你的目标是使用最少的跳跃次数到达数组的最后一个位置。

        假设你总是可以到达数组的最后一个位置。
 输入: nums = [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。*/


public class Jump {
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};


        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {

        int n = nums.length;
        int dp[] = new int[n];
        int start = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = start; j < i; ++j) {
                int k = nums[j];
                if (j + nums[j] >= i) {
                    start = j;
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}