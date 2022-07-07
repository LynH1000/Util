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

    public int solution(String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新

          //*** debug 输出的位置 ***//*
            System.out.println("window: [" + left + "," + right + ")");
          //********************//*

            // 判断左侧窗口是否要收缩
            while (window needs shrink){
                // d 是将移出窗口的字符
                char d = s[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新

            }
        }


        return 0;
    }
}
