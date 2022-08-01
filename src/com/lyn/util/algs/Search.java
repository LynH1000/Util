package com.lyn.util.algs;

/*
* 
* 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
* */
public class Search {
    public int solution(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;


        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int ans = nums[mid];
            if (ans > target) {
                right = mid - 1;
            } else if (ans < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
