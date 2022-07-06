package com.lyn.util.algs;

import java.util.HashMap;
import java.util.Map;

/*给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
任何误差小于 10-5 的答案都将被视为正确答案。

输入：nums = [1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class FindMaxAverage {

    public static void main(String[] args) {
        int nums[]= {1,12,-5,-6,50,3};
        int k=4;
        double result=solution(nums,k);
        System.out.println();
    }

    public static double solution(int[] nums, int k) {
        double max_sum = 0;
        double max_avg = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            // c 是将移入窗口的字符
            max_sum += nums[right];
            if(right - left + 1 == k){
                max_avg = Math.max(max_avg, max_sum/k);
            }
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新

            /*** debug 输出的位置 ***/
            System.out.println("window: [" + left + "," + right + ")");
            /********************/

            // 判断左侧窗口是否要收缩
            while ((right - left + 1) > k){
                // d 是将移出窗口的字符
                max_sum -= nums[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新

            }
        }
        return max_avg;
    }
}
