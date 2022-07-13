package com.lyn.util.algs;

/*
* 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。
*
*输入：x = -123
输出：-321
*/
public class NumbeReverse {
    public int solution1(int x) {
        Integer i = x;
        Integer ans = null;
        StringBuilder s = new StringBuilder(i.toString());
        if (x < 0) {
            s.reverse().insert(0, "-");
            ans = Math.toIntExact(Math.max(Integer.MIN_VALUE, Long.valueOf(s.substring(0, s.length() - 1))));
        } else {
            s.reverse();
            ans = Math.toIntExact(Math.min(Integer.MAX_VALUE, Long.valueOf(s.toString())));
        }
        if (ans == Integer.MAX_VALUE || ans == Integer.MIN_VALUE) {
            ans = 0;
        }
        return ans;
    }

    public int solution2(int x) {
        int num=x;
        int ans=0;
        int digit=0;
        while (num!=0){
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            digit=num%10;
            ans=ans*10+digit;
            num/=10;
        }
        return ans;
    }
}
