package com.lyn.util.algs;

/*最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。
*/


public class LongestPalindrome {

    public String solution(String s) {
        if (s == null) {
            return null;
        }
        char c[] = s.toCharArray();
        int max = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < c.length; i++) {

            int oneMid = find(c, i, i);
            int twoMid = find(c, i, i + 1);
            max = Math.max(oneMid, twoMid);

            if (max > right - left) {
                left = i - (max - 1) / 2;
                right = i + max / 2;
            }
        }

        return s.substring(left + 1, right);
    }

    public int find(char[] c, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < c.length && c[R] == c[L]) {
            L--;
            R++;
        }
        return R - L + 1;
    }


}
