package com.lyn.util.alrg;

public class ClimbStairs {


    public int solution(int n) {

        // write your code here
        int memo[] = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;// 第一个台阶，只有一种方法，就是爬一个台阶
        dp[2] = 2;// 第二个台阶，有两种方法，一种是爬一个台阶，一种是爬两个台阶

        //由此可得出，如果要爬到第三个台阶，有两种方法，从二阶爬一个台阶，从一阶爬两个台阶
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
