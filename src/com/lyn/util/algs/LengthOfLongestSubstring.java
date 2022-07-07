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

        Map<Character, Integer> window = new HashMap<>();
        if (s.length() == 1) return 1;
        int left = 0, right = 0;
        int count = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            //*** debug 输出的位置 ***//*
            // System.out.println("window: [" + left + "," + right + ")");
            //********************//*
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                count = Math.max(right - (left + 1), count);
                //更新窗口——这段代码逻辑几乎完全同上面的更新窗口
                char d = s.charAt(left);
                left++;//窗口缩小
                window.put(d, window.get(d) - 1);
            }
        }
        return count;
    }
}


