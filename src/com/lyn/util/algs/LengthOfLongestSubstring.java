package com.lyn.util.algs;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

* 输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s="au";
        System.out.println(solution(s));
    }

    public static int solution(String s) {

        Map<Character, Integer> rom = new HashMap<>();
        if (s.length() == 0) return 0;
        int left = 0, right = 0;
        int count = 0;
        while (right < s.length()) {
            if (rom.containsKey(s.charAt(right))) {
                left = Math.max(rom.get(s.charAt(right)) + 1, left);
            }
            rom.put(s.charAt(right), right);
            count = Math.max(right - left + 1, count);

            right++;
        }
        return count;
    }
}


